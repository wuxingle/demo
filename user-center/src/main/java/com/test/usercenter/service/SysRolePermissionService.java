package com.test.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.usercenter.entity.SysRolePermission;

import java.util.List;

public interface SysRolePermissionService extends IService<SysRolePermission> {
    List<SysRolePermission> selectByRoleId(Integer roleId);
}
