package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.apicommon.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role_function")
public class SysRoleFunction extends BaseEntity implements Serializable {

    private String roleId;
    private String functionId;

}