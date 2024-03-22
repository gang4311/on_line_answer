package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.Result;
import com.tencent.wxcloudrun.dto.UserAnswerDetailAo;
import com.tencent.wxcloudrun.dto.UserAnswerDetailRequest;
import com.tencent.wxcloudrun.service.UserAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/userAnswer")
@Slf4j
@Api("用户答题服务")
public class UserAnswerController {

    @Autowired
    UserAnswerService userAnswerService;


    @GetMapping("/queryUserPaperAnswerDetail")
    @ApiOperation("查询用户试卷答案")
    public Result<List<UserAnswerDetailAo>> queryUserPaperAnswerDetail(Long paperId){
        return Result.ok(userAnswerService.queryUserPaperAnswerDetail(paperId));
    }

    @GetMapping("/queryUserQuestionAnswerDetail")
    @ApiOperation("查询用户每题答案")
    public Result<UserAnswerDetailAo> queryUserQuestionAnswerDetail(Long questionId){
        return Result.ok(userAnswerService.queryUserQuestionAnswerDetail(questionId));
    }

    @GetMapping("/addUserQuestionAnswer")
    @ApiOperation("添加用户答案")
    public  Result<Boolean> addUserQuestionAnswer(UserAnswerDetailRequest request){
        return Result.ok(userAnswerService.addUserQuestionAnswer(request));
    }
}
