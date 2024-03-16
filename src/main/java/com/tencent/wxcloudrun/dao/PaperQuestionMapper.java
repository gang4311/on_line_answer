package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.PaperQuestion;

public interface PaperQuestionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaperQuestion record);

    int insertSelective(PaperQuestion record);

    PaperQuestion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaperQuestion record);

    int updateByPrimaryKey(PaperQuestion record);
}