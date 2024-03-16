package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Question;
import com.tencent.wxcloudrun.model.QuestionWithBLOBs;

public interface QuestionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionWithBLOBs record);

    int insertSelective(QuestionWithBLOBs record);

    QuestionWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionWithBLOBs record);

    int updateByPrimaryKey(Question record);
}