package com.test.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.usercenter.entity.SysRoleUser;
import com.test.usercenter.vo.AccreditVo;

public interface SysRoleUserService extends IService<SysRoleUser> {
    AccreditVo getUserRole(String userId);
}
