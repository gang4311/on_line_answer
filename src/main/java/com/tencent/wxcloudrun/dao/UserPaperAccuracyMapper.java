package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserPaperAccuracy;

public interface UserPaperAccuracyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPaperAccuracy record);

    int insertSelective(UserPaperAccuracy record);

    UserPaperAccuracy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPaperAccuracy record);

    int updateByPrimaryKey(UserPaperAccuracy record);
}