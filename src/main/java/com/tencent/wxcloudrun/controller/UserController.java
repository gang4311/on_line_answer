package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.Result;
import com.tencent.wxcloudrun.dto.AdminUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api("用户服务")
public class UserController {

    @PostMapping("/adminLogin")
    @ApiOperation("管理员登陆")
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
