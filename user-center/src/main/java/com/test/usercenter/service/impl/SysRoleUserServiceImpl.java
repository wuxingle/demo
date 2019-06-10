package com.test.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.usercenter.entity.SysPermission;
import com.test.usercenter.entity.SysRole;
import com.test.usercenter.entity.SysRolePermission;
import com.test.usercenter.entity.SysRoleUser;
import com.test.usercenter.mapper.SysRoleUserMapper;
import com.test.usercenter.service.SysPermissionService;
import com.test.usercenter.service.SysRolePermissionService;
import com.test.usercenter.service.SysRoleService;
import com.test.usercenter.service.SysRoleUserService;
import com.test.usercenter.vo.AccreditVo;
import com.test.usercenter.vo.PremissionVo;
import com.test.usercenter.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserMapper, SysRoleUser> implements SysRoleUserService {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;
    @Autowired
    private SysPermissionService sysPermissionService;


    @Override
    public AccreditVo getUserRole(String userId) {
        //查询用户角色绑定关系
        List<SysRoleUser> sysRoleUserList=baseMapper.selectByUserId(userId);
        if (sysRoleUserList==null||sysRoleUserList.size()==0){
            return null;
        }
        AccreditVo accreditVo=new AccreditVo();
        List<RoleVo> roleVoList=new ArrayList<>();
        accreditVo.setUserId(userId);
        for (SysRoleUser sysRoleUser:sysRoleUserList) {
            RoleVo roleVo=new RoleVo();
            roleVo.setRoleId(sysRoleUser.getRoleId());
            //查询角色
            SysRole sysRole=sysRoleService.selectById(sysRoleUser.getRoleId());
            if (sysRole!=null){
                roleVo.setRoleCode(sysRole.getCode());
                roleVo.setRoleName(sysRole.getName());
            }
            //获取角色对应的权限
            List<SysRolePermission> sysRolePermissionList=sysRolePermissionService.selectByRoleId(sysRoleUser.getRoleId());
            List<PremissionVo> premissionVoList=new ArrayList<>();
            if (sysRolePermissionList!=null&&sysRolePermissionList.size()!=0){
                for (SysRolePermission sysRolePermission:sysRolePermissionList) {
                    SysPermission sysPermission=sysPermissionService.selectById(sysRolePermission.getPermissionId());
                    if (sysPermission!=null) {
                        PremissionVo premissionVo = new PremissionVo();
                        premissionVo.setId(sysRolePermission.getPermissionId());
                        premissionVo.setPremissionCode(sysPermission.getCode());
                        premissionVo.setPremissionName(sysPermission.getName());
                        premissionVo.setSort(sysPermission.getSort());
                        premissionVo.setType(sysPermission.getType());
                        premissionVo.setUrl(sysPermission.getUrl());
                        premissionVoList.add(premissionVo);
                    }
                }
            }
            roleVo.setPremissionVoList(premissionVoList);
            roleVoList.add(roleVo);
        }
        accreditVo.setRoleList(roleVoList);

        return accreditVo;
    }
}
