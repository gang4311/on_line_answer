package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionRequest {

    private Long id;

    private Integer number;

    private Byte type;

    private String answer;

    private String content;

    private String analysis;

    private Long paperId;
}
