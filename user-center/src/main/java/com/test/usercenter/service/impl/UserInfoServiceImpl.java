package com.test.usercenter.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.apicommon.security.LoginUser;
import com.test.usercenter.entity.UserInfo;
import com.test.usercenter.mapper.UserInfoMapper;
import com.test.usercenter.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Override
    public UserInfo selectUserByPhoneNo(String phoneNo) {
       return baseMapper.selectUserByPhoneNo(phoneNo);
    }

    @Override
    public LoginUser conveter2LoginUser(UserInfo userInfo) {
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(userInfo, loginUser);
        loginUser.setAddressId(userInfo.getAreaId());
        //出生日期
        if (userInfo.getBirthDate() != null) {
            loginUser.setBirthDate(userInfo.getBirthDate());
        }
        return loginUser;
    }

    @Override
    public UserInfo selectUserByName(String name) {
        return baseMapper.selectUserByName(name);
    }

    private Date getDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }
}
