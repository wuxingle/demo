package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_role_user")
public class SysRoleUser implements Serializable {
    private Integer roleId;
    private String userId;

}