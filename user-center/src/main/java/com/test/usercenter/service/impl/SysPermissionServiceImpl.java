package com.test.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.usercenter.entity.SysPermission;
import com.test.usercenter.mapper.SysPermissionMapper;
import com.test.usercenter.service.SysPermissionService;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Override
    public SysPermission selectById(Integer id) {
        return baseMapper.selectById(id);
    }
}
