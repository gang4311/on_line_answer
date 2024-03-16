package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserAnswerDetail;

public interface UserAnswerDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAnswerDetail record);

    int insertSelective(UserAnswerDetail record);

    UserAnswerDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAnswerDetail record);

    int updateByPrimaryKey(UserAnswerDetail record);
}