package com.tencent.wxcloudrun.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionAo {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private Byte isDel;

    private Integer number;

    private Byte type;

    private String answer;

    private String content;

    private String analysis;
}
