package com.common.apicommon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetail implements Serializable {

    private String id;
    private String name;
    private String loginName;
    private String password;
    private String phoneNo;
    private String sex;
    private String address;
    private Integer addressId;
    private Date birthDate;
    private String height;
    private String weight;
    private String identityNo;
    private String profession;
    private String status;

    protected List<String> roles;
    protected List<String> permissions;

}
