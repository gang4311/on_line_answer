package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.wxcloudrun.dto.PaperAo;
import com.tencent.wxcloudrun.dto.PaperRequest;

import java.util.List;

public interface PaperService {

  List<PaperAo> queryAll(Page<PaperRequest> request);

  PaperAo queryById(Long id);

  Boolean updateById(PaperRequest request);

  Boolean addPaper(PaperRequest request);
}
