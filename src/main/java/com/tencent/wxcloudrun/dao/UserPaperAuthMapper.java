package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserPaperAuth;

public interface UserPaperAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPaperAuth record);

    int insertSelective(UserPaperAuth record);

    UserPaperAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPaperAuth record);

    int updateByPrimaryKey(UserPaperAuth record);
}