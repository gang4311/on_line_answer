package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Paper;

public interface PaperMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}