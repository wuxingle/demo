package com.test.usercenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.common.apicommon.security.LoginUser;
import com.test.usercenter.entity.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    /**
     * 通过手机号查询用户
     *
     * @param phoneNo
     * @return
     */
    UserInfo selectUserByPhoneNo(String phoneNo);


    LoginUser conveter2LoginUser(UserInfo userInfo);

    UserInfo selectUserByName(String name);

}
