package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.QuestionAo;
import com.tencent.wxcloudrun.dto.QuestionRequest;

import java.util.List;

public interface QuestionService {

   List<QuestionAo> queryByPaperId(Long paperId);

   Boolean addQuestion(QuestionRequest question);

   Boolean updateById(QuestionRequest question);

   Boolean removeById(Long id);
}
