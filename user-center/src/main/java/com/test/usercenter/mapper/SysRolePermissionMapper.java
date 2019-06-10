package com.test.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.usercenter.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
    List<SysRolePermission> selectByRoleId(Integer roleId);

}