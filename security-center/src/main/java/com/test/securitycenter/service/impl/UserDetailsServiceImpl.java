package com.test.securitycenter.service.impl;


import com.common.apicommon.Constants;
import com.common.apicommon.exception.BusinessException;
import com.common.apicommon.security.LoginUser;
import com.test.securitycenter.remote.UserRemoteClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRemoteClient userRemoteClient;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (StringUtils.isNotEmpty(userName)) {
            String[] userNameArr = userName.split("\\|");
            if (userNameArr.length > 3) {
                String phoneNo = userNameArr[0];
                String type = userNameArr[2];
                LoginUser user = userRemoteClient.getUserByPhoneNo(phoneNo).getData();
                if (user != null) {
                    if (user.isEnabled()) {
                        if ((Constants.ONE + "").equalsIgnoreCase(type)) {//密码登录
                            processPasswordLogin(user, userNameArr);
                        } else if ((Constants.ZERO + "").equalsIgnoreCase(type)) {//验证码登录
                            processVerifyCodeLogin(user, userNameArr);
                        }
                        return user;
                    } else {
                        throw new DisabledException("用户账户已被冻结");
                    }
                } else {
                    throw new AuthenticationCredentialsNotFoundException("用户不存在");
                }
            } else {
                String name=userNameArr[0];
                String type = userNameArr[1];
                 if("A".equalsIgnoreCase(type)){
                     return userRemoteClient.getUserByName(name).getData();
                 }else if("C".equalsIgnoreCase(type)){
//                     return userCompanyRemoteClient.getCompanyUserByName(name).getData();
                 }else{
                     return null;
                 }
            }
        }
        return null;
    }

    private void processVerifyCodeLogin(LoginUser loginUser, String[] params) {
//        if (params != null && params.length > 2) {
//            VerifyCodeVo codeVo = new VerifyCodeVo();
//            codeVo.setPhoneNo(params[0]);
//            codeVo.setVerificationCode(params[1]);
//            VerifyResultVo verifyResultVo = notificationRemoteClient.checkVerificationCode(codeVo).getData();
//            if (!(verifyResultVo != null && Constants.YES.equalsIgnoreCase(verifyResultVo.getStatus()))) {
//                throw new BusinessException(4000, "验证码有误!");
//            }
//            loginUser.setPassword(bCryptPasswordEncoder.encode(params[1]));
//        }
    }

    private void processPasswordLogin(LoginUser loginUser, String[] params) {
        if (params != null && params.length > 2) {
            String password = params[1];
            if (!bCryptPasswordEncoder.matches(password, loginUser.getPassword())) {
                throw new BusinessException(4000, "密码不匹配");
            }
        }
    }
}
