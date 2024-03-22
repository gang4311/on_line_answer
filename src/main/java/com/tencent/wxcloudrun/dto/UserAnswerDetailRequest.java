package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class UserAnswerDetailRequest {

    private Long id;

    private Long userId;

    private Long questionId;

    private Long paperId;

    private String answer;
}
