package com.tencent.wxcloudrun.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.wxcloudrun.dto.PaperAo;
import com.tencent.wxcloudrun.dto.PaperRequest;
import com.tencent.wxcloudrun.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaperServiceImpl implements PaperService {
    @Override
    public List<PaperAo> queryAll(Page<PaperRequest> request) {
        return null;
    }

    @Override
    public PaperAo queryById(Long id) {
        return null;
    }

    @Override
    public Boolean updateById(PaperRequest request) {
        return null;
    }

    @Override
    public Boolean addPaper(PaperRequest request) {
        return null;
    }
}
