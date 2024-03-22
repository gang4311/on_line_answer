package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dto.UserAnswerDetailAo;
import com.tencent.wxcloudrun.dto.UserAnswerDetailRequest;
import com.tencent.wxcloudrun.service.UserAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {
    @Override
    public List<UserAnswerDetailAo> queryUserPaperAnswerDetail(Long paperId) {
        return null;
    }

    @Override
    public UserAnswerDetailAo queryUserQuestionAnswerDetail(Long questionId) {
        return null;
    }

    @Override
    public Boolean addUserQuestionAnswer(UserAnswerDetailRequest request) {
        return null;
    }
}
