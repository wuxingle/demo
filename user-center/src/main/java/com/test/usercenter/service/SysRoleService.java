package com.test.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.usercenter.entity.SysRole;

public interface SysRoleService extends IService<SysRole> {
    SysRole selectById(Integer id);
}
