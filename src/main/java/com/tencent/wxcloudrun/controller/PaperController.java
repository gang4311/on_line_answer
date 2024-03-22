package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.wxcloudrun.common.Result;
import com.tencent.wxcloudrun.dto.PaperAo;
import com.tencent.wxcloudrun.dto.PaperRequest;
import com.tencent.wxcloudrun.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/paper")
@Slf4j
@Api("试卷服务")
public class PaperController {


    @Autowired
    PaperService paperService;
    @GetMapping("/getAll")
    @ApiOperation("分页查询全部试卷")
    public Result<List<PaperAo>> getAll(Page<PaperRequest> page){
       return Result.ok(paperService.queryAll(page));
    }

}
