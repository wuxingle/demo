package com.common.apicommon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDetail implements Serializable {

    private String id;
    private String name;
    private String loginName;
    private String password;
    private String phoneNo;
    private String sex;
    private String address;
    private Integer addressId;
    @JsonFormat(pattern="yyyy-MM-dd",locale = "zh", timezone="GMT+8")
    private Date birthDate;
    private String height;
    private String weight;
    private String identityNo;
    private String profession;
    private String status;
    private Integer regionId;
    private Integer cityId;
    private Integer provinceId;

    protected List<String> roles;
    protected List<String> permissions;

    private String userType="A"; //A/C   A:APP用户  C:后台管理员

}
