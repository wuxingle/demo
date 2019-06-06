package com.common.apicommon.security;


import com.common.apicommon.model.UserInfoDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;

public class SessionUserUtil {
    public static UserInfoDetail getCurrentLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication oAuth2Auth = (OAuth2Authentication) authentication;
            authentication = oAuth2Auth.getUserAuthentication();
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                UserInfoDetail userInfoDetail = new UserInfoDetail();
                UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;
                Object principal = authentication.getPrincipal();
                if (principal instanceof LoginUser) {
                    BeanUtils.copyProperties(principal, userInfoDetail);
                    return userInfoDetail;
                } else {
                    Map map = (Map) ((Map) authenticationToken.getDetails()).get("principal");
                    if (map != null) {
                        userInfoDetail.setId((String)map.get("id"));
                        userInfoDetail.setName((String)map.get("name"));
                        userInfoDetail.setLoginName((String)map.get("loginName"));
                        userInfoDetail.setPhoneNo((String)map.get("phoneNo"));
                        userInfoDetail.setStatus((String)map.get("status"));
                        return userInfoDetail;
                    }
                }
            }
        }
        return null;
    }
    public static String getCurrentUserId() {
        UserInfoDetail user = getCurrentLoginUser();
        return user == null ? null : user.getId();
    }

    public static String getCurrentUserName() {
        UserInfoDetail user = getCurrentLoginUser();
        return user == null ? null : user.getName();
    }

    public static String getCurrentPhoneNo() {
        UserInfoDetail user = getCurrentLoginUser();
        return user == null ? null : user.getPhoneNo();
    }

//    public static LoginUser getCurrentLoginUser() {
//        LoginUser currentLoginUser = new LoginUser();
//        currentLoginUser.setId("system"); // 后期扩展,从授权中心读取
//        return currentLoginUser;
//    }

//    public static String getLoginUserId() {
//        LoginUser user = getCurrentLoginUser();
//        return user == null ? null : user.getId();
//    }
//
//    public static String getUserName() {
//        LoginUser user = getCurrentLoginUser();
//        return user == null ? null : user.getName();
//    }
//
//    public static String getPhoneNo() {
//        LoginUser user = getCurrentLoginUser();
//        return user == null ? null : user.getPhoneNo();
//    }
}
