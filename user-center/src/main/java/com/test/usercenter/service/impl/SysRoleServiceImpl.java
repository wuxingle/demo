package com.test.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.usercenter.entity.SysRole;
import com.test.usercenter.mapper.SysRoleMapper;
import com.test.usercenter.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public SysRole selectById(Integer id) {
        return baseMapper.selectById(id);
    }
}
