package com.test.usercenter.controller;

import com.common.apicommon.StatusCode;
import com.common.apicommon.exception.CustomThrow;
import com.common.apicommon.model.ResultData;
import com.common.apicommon.security.LoginUser;
import com.test.usercenter.entity.UserInfo;
import com.test.usercenter.service.SysRoleUserService;
import com.test.usercenter.service.UserInfoService;
import com.test.usercenter.vo.AccreditVo;
import com.test.usercenter.vo.PremissionVo;
import com.test.usercenter.vo.RoleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/user/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysRoleUserService sysRoleUserService;

    @PreAuthorize("hasAuthority('user:changephoneno')" )
    @GetMapping(value = "/getUserById",params = {"id"})
    public boolean getUserById(@RequestParam("id")String id){
        UserInfo userInfo=userInfoService.getById(id);
        if (userInfo==null){
            return false;
        }else {
            return true;
        }
    }


    @GetMapping(value = "/getUserByPhoneNo")
    public ResultData<LoginUser> getUserByPhoneNo(@RequestParam("phoneNo") String phoneNo) {
        if (!StringUtils.isEmpty(phoneNo)) {
            UserInfo userInfo = userInfoService.selectUserByPhoneNo(phoneNo);
            if (userInfo != null) {
                LoginUser loginUser =userInfoService.conveter2LoginUser(userInfo);
                return new ResultData<>(loginUser);
            }
        }
        return CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
    }

    @GetMapping(value = "/internal/getUserByPhoneNo")
    public ResultData<LoginUser> getUserByPhoneNoInternal(@RequestParam("phoneNo") String phoneNo) {
        if (!StringUtils.isEmpty(phoneNo)) {
            UserInfo userInfo = userInfoService.selectUserByPhoneNo(phoneNo);
            if (userInfo != null) {
                LoginUser loginUser = processLoginUser(userInfo);
                return new ResultData<>(loginUser);
            }
        }
        return CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
    }

    @GetMapping(value = "/internal/getUserByName")
    public ResultData<LoginUser> getUserByName(@RequestParam("name") String name) {
        if (!StringUtils.isEmpty(name)) {
            UserInfo userInfo = userInfoService.selectUserByName(name);
            if (userInfo != null) {
                LoginUser loginUser = processLoginUser(userInfo);
                return new ResultData<>(loginUser);
            }
        }
        return CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
    }


    private LoginUser processLoginUser(UserInfo userInfo) {
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(userInfo, loginUser);
        if (!StringUtils.isEmpty(userInfo.getId())) {
            AccreditVo accreditVo = sysRoleUserService.getUserRole(userInfo.getId());
            List<String> role = new ArrayList<String>();
            List<String> permission = new ArrayList<String>();
            if (accreditVo != null) {
                List<RoleVo> list = accreditVo.getRoleList();
                if (list != null && list.size() > 0) {
                    for (RoleVo vo : list) {
                        role.add(vo.getRoleCode());
                        if (vo.getPremissionVoList() != null) {
                            for (PremissionVo premissionVo : vo.getPremissionVoList()) {
                                permission.add(premissionVo.getPremissionCode());
                            }
                        }
                    }
                }
            }
            loginUser.setRoles(role);
            loginUser.setPermissions(permission);
        }
        return loginUser;
    }


}
