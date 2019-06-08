package com.test.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.usercenter.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo selectUserByPhoneNo(String phoneNo);

    UserInfo selectUserByName(String name);

    int insertSelective(UserInfo record);

    int updateByPrimaryKeySelective(UserInfo record);

}