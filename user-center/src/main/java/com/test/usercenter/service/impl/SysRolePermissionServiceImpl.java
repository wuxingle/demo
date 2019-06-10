package com.test.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.usercenter.entity.SysRolePermission;
import com.test.usercenter.mapper.SysRolePermissionMapper;
import com.test.usercenter.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
    @Override
    public List<SysRolePermission> selectByRoleId(Integer roleId) {
        return baseMapper.selectByRoleId(roleId);
    }
}
