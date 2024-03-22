package com.tencent.wxcloudrun.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.wxcloudrun.common.Result;
import com.tencent.wxcloudrun.dto.PaperAo;
import com.tencent.wxcloudrun.dto.PaperRequest;
import com.tencent.wxcloudrun.dto.QuestionAo;
import com.tencent.wxcloudrun.dto.QuestionRequest;
import com.tencent.wxcloudrun.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/question")
@Slf4j
@Api("答题服务")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getPaperQuestion")
    @ApiOperation("查询试卷题目")
    public Result<List<QuestionAo>> getPaperQuestion(QuestionRequest request){
        return Result.ok(questionService.queryByPaperId(request.getPaperId()));
    }


}
