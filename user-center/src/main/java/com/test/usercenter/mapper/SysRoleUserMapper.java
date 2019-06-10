package com.test.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.usercenter.entity.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper extends BaseMapper<SysRoleUser> {
    List<SysRoleUser> selectByUserId(String userId);

}