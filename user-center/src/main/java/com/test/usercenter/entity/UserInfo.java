package com.test.usercenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.apicommon.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user_info")
public class UserInfo extends BaseEntity implements Serializable {

    private String name;
    private String loginName;
    private String code;
    private String password;
    private String phoneNo;
    private String sex;
    private Integer areaId;
    private Date birthDate;
    private String height;
    private String weight;
    private String identityNo;
    private Integer professionId;
    private String headPicResId;
    private String bmi;
    private String weixinAccount;
    private String alipayAccount;
    private String qq;
    private String isSmoking;
    private String isDrinking;
    private String status;
    private String source;
    private String remark;


}