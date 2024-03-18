package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.Result;
import com.tencent.wxcloudrun.dto.AdminUserRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@Slf4j
public class CounterController {

  final CounterService counterService;
  final Logger logger;

  public CounterController(@Autowired CounterService counterService) {
    this.counterService = counterService;
    this.logger = LoggerFactory.getLogger(CounterController.class);
  }


  /**
   * 获取当前计数
   * @return API response json
   */
  @GetMapping(value = "/api/count")
  Result get() {
    logger.info("/api/count get request");
    Optional<Counter> counter = counterService.getCounter(1);
    Integer count = 0;
    if (counter.isPresent()) {
      count = counter.get().getCount();
    }

    return Result.ok(count);
  }


  /**
   * 更新计数，自增或者清零
   * @param request {@link CounterRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/count")
  Result create(@RequestBody CounterRequest request) {
    logger.info("/api/count post request, action: {}", request.getAction());

    Optional<Counter> curCounter = counterService.getCounter(1);
    if (request.getAction().equals("inc")) {
      Integer count = 1;
      if (curCounter.isPresent()) {
        count += curCounter.get().getCount();
      }
      Counter counter = new Counter();
      counter.setId(1);
      counter.setCount(count);
      counterService.upsertCount(counter);
      return Result.ok(count);
    } else if (request.getAction().equals("clear")) {
      if (!curCounter.isPresent()) {
        return Result.ok(0);
      }
      counterService.clearCount(1);
      return Result.ok(0);
    } else {
      return Result.error("参数action错误");
    }
  }


  @PostMapping("/adminLogin")
  @ApiOperation("管理员登陆")
  @ApiImplicitParam(name = "user,",value = "用户名秘密",dataType = "AdminUserRequest")
  public Result<Object> UserLogin(@RequestBody AdminUserRequest user)
  {
    String username=user.getUserName();
    String password=user.getPassword();
    //shiro验证
    Subject subject= SecurityUtils.getSubject();
    //根据用户名密码生成一个令牌
    UsernamePasswordToken token=new UsernamePasswordToken(username,password);
    try {
      subject.login(token);    //执行登录操作
    } catch (UnknownAccountException e) {
      log.info("登录用户不存在");
      return new Result<>(416,"用户不存在",username);
    } catch (IncorrectCredentialsException e) {
      log.info("登录密码错误");
      return new Result<>(412,"密码错误，请重新登录",password);
    }catch (AuthenticationException e) {
      log.warn("用户登录异常:" + e.getMessage());
      return new Result<>(416,"账户异常",username);
    }
    return new Result<>(200,"登录成功",username);
  }

}