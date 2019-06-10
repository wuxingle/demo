package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.common.apicommon.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("sys_permission")
public class SysPermission implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String type;
    private Integer sort;
    private String url;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

}