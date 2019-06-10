package com.test.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.usercenter.entity.SysPermission;

public interface SysPermissionService extends IService<SysPermission> {
    SysPermission selectById(Integer id);
}
