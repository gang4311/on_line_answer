package com.tencent.wxcloudrun.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
public class UserAnswerDetailAo {

    private Long id;

    private Long userId;

    private Long questionId;

    private Long paperId;

    private String answer;

}