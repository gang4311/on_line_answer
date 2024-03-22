package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dto.QuestionAo;
import com.tencent.wxcloudrun.dto.QuestionRequest;
import com.tencent.wxcloudrun.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<QuestionAo> queryByPaperId(Long paperId) {
        return null;
    }

    @Override
    public Boolean addQuestion(QuestionRequest question) {
        return null;
    }

    @Override
    public Boolean updateById(QuestionRequest question) {
        return null;
    }

    @Override
    public Boolean removeById(Long id) {
        return null;
    }
}
