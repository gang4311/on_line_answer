package com.tencent.wxcloudrun.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class AdminUserRequest {

    @NonNull
    private String userName;

    @NonNull
    private String password;

}
