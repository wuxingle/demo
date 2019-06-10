package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.apicommon.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_role")
public class SysRole  implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private Date createDate;

}