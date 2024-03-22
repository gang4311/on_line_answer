package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.UserAnswerDetailAo;
import com.tencent.wxcloudrun.dto.UserAnswerDetailRequest;

import java.util.List;

public interface UserAnswerService {

    List<UserAnswerDetailAo> queryUserPaperAnswerDetail(Long paperId);

    UserAnswerDetailAo queryUserQuestionAnswerDetail(Long questionId);

    Boolean addUserQuestionAnswer(UserAnswerDetailRequest request);


}
