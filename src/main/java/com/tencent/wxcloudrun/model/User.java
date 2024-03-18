package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@TableName(value = "user")
@Data
public class User {

    @TableId(value="id",type = IdType.AUTO)
    private Long id;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("create_by")
    private String createBy;

    @TableField("update_by")
    private String updateBy;

    @TableField("is_del")
    private Byte isDel;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("open_id")
    private String openId;

    @TableField("icon")
    private String icon;

    @TableField("phone")
    private String phone;

    @TableField("type")
    private Byte type;

    @TableField("login_name")
    private String loginName;

}