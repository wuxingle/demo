package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.apicommon.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_function_permission")
public class SysFunctionPermission implements Serializable {
    private Integer functionId;
    private Integer permissionId;
}