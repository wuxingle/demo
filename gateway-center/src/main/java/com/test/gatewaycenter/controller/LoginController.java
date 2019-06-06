package com.test.gatewaycenter.controller;

import cn.hutool.json.JSONObject;
import com.common.apicommon.Constants;
import com.common.apicommon.StatusCode;
import com.common.apicommon.exception.CustomThrow;
import com.common.apicommon.model.ResultData;
import com.common.apicommon.security.HealthcareClientInfo;
import com.common.apicommon.security.LoginUser;
import com.common.apicommon.utils.MD5Util;
import com.test.gatewaycenter.remote.SecurityRemoteClient;
import com.test.gatewaycenter.remote.UserRemoteClient;
import feign.FeignException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserRemoteClient userRemoteClient;
    @Autowired
    private SecurityRemoteClient securityRemoteClient;

//    @PostMapping(value = "/suibuaa/login_old", params = {"phoneNo", "password", "type"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ResultData<LoginUser> login(String phoneNo, String password, String type) {
//        try {
//            if (StringUtils.isNotEmpty(phoneNo) && StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(type)) {
//                ResultData resultData = userRemoteClient.getUserByPhoneNo(phoneNo);
//                if (resultData != null) {
//                    LoginUser loginUser = (LoginUser) resultData.getData();
//                    if (loginUser != null) {
//                        if ((Constants.ONE + "").equalsIgnoreCase(type)) { //密码登陆
//                            if (MD5Util.MD5(password).equalsIgnoreCase(loginUser.getPassword())) {
//                                return new ResultData<LoginUser>(loginUser);
//                            } else {
//                                CustomThrow.throwCustom(StatusCode.PARAMETERR_PASSWORD_ERROR.getErrorCode(),StatusCode.PARAMETERR_PASSWORD_ERROR.getErrorMessage());
//                            }
//                        } else if ((Constants.ZERO + "").equalsIgnoreCase(type)) { //验证码登陆
//                            VerifyCodeVo codeVo = new VerifyCodeVo();
//                            codeVo.setPhoneNo(phoneNo);
//                            codeVo.setVerificationCode(password);
//                            VerifyResultVo verifyResultVo = notificationRemoteClient.checkVerificationCode(codeVo).getData();
//                            if (verifyResultVo != null && Constants.YES.equalsIgnoreCase(verifyResultVo.getStatus())) {
//                                return new ResultData<LoginUser>(loginUser);
//                            } else {
//                                CustomThrow.throwCustom(StatusCode.PARAMETERR_PASSWORD_ERROR.getErrorCode(),StatusCode.PARAMETERR_PASSWORD_ERROR.getErrorMessage());
//                            }
//                        }
//                    } else {
//                        CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return CustomThrow.throwCustom(StatusCode.OPERATE_ERROR.getErrorCode(),StatusCode.OPERATE_ERROR.getErrorMessage());
//        }
//        return CustomThrow.throwCustom(StatusCode.OPERATE_ERROR.getErrorCode(),StatusCode.OPERATE_ERROR.getErrorMessage());
//    }

    @PostMapping(value = "/suibuaa/login", params = {"phoneNo", "password", "type"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResultData login_new(String phoneNo, String password, String type) {
        if (StringUtils.isEmpty(phoneNo)) {
            return CustomThrow.throwCustom(StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorCode(),StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorMessage());
        }else{
            ResultData userResult = userRemoteClient.getUserByPhoneNo(phoneNo);
            if (userResult == null || userResult.getData() == null) {
                return CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
            }
        }
        if (StringUtils.isEmpty(password)) {
            return CustomThrow.throwCustom(StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorCode(),StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorMessage());
        }
        if (StringUtils.isEmpty(type)) {
            return CustomThrow.throwCustom(StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorCode(),StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorMessage());
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
        parameters.put(OAuth2Utils.CLIENT_ID, HealthcareClientInfo.MOBILE_CLIENT_ID);
        parameters.put("client_secret", HealthcareClientInfo.MOBILE_CLIENT_SECRET);
        parameters.put(OAuth2Utils.SCOPE, HealthcareClientInfo.MOBILE_CLIENT_SCOPE);
        parameters.put("username", phoneNo + "|" + password + "|" + type+"|"+"A");
        parameters.put("password", password);
        try{
            Map<String, Object> tokenInfo = securityRemoteClient.postAccessToken(parameters);
            removeUserPermissionInfo(tokenInfo);
            return new ResultData(tokenInfo);
        }catch (FeignException e){
            String message = e.getMessage();
            JSONObject jsonObject = new JSONObject(message.substring(message.indexOf("{")));
            return CustomThrow.throwCustom((String)jsonObject.get("error_description"));
        }
    }

//    @PostMapping(value = "/suibuaa/login_system", params = {"userName", "password"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ResultData logins_system(String userName, String password) {
//        if (StringUtils.isEmpty(userName)) {
//            return CustomThrow.throwCustom(StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorCode(),StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorMessage());
//        }else{
//            ResultData userResult = userCompanyRemoteClient.getCompanyUserByPhoneNo(userName);
//            if (userResult == null || userResult.getData() == null) {
//                return CustomThrow.throwCustom(StatusCode.USER_NOT_EXIST.getErrorCode(),StatusCode.USER_NOT_EXIST.getErrorMessage());
//            }
//        }
//        if (StringUtils.isEmpty(password)) {
//            return CustomThrow.throwCustom(StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorCode(),StatusCode.PARAMETERR_VALIDATION_ERROR.getErrorMessage());
//        }
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
//        parameters.put(OAuth2Utils.CLIENT_ID, HealthcareClientInfo.SYSTEM_CLIENT_ID);
//        parameters.put("client_secret", HealthcareClientInfo.SYSTEM_CLIENT_SECRET);
//        parameters.put(OAuth2Utils.SCOPE, HealthcareClientInfo.SYSTEM_CLIENT_SCOPE);
//        parameters.put("username", userName+"|"+"C");
//        parameters.put("password", password);
//        try{
//            Map<String, Object> tokenInfo = securityRemoteClient.postAccessToken(parameters);
//            removeUserPermissionInfo(tokenInfo);
//            return new ResultData(tokenInfo);
//        }catch (FeignException e){
//            String message = e.getMessage();
//            JSONObject jsonObject = new JSONObject(message.substring(message.indexOf("{")));
//            return CustomThrow.throwCustom(jsonObject.toString());
//        }
//    }

    @GetMapping("/suibuaa/logout")
    public ResultData logout(String access_token) {
        ResultData resultData = securityRemoteClient.removeToken(access_token);
        if (resultData != null && resultData.getData() != null && (Boolean)resultData.getData()) {
            return ResultData.success();
        } else {
            return ResultData.failure("logout failure");
        }
    }

    @PostMapping("/suibuaa/refresh_token")
    public ResultData refresh_token(String refresh_token) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(OAuth2Utils.GRANT_TYPE, "refresh_token");
        parameters.put(OAuth2Utils.CLIENT_ID, HealthcareClientInfo.MOBILE_CLIENT_ID);
        parameters.put("client_secret", HealthcareClientInfo.MOBILE_CLIENT_SECRET);
        parameters.put(OAuth2Utils.SCOPE, HealthcareClientInfo.MOBILE_CLIENT_SCOPE);
        parameters.put("refresh_token", refresh_token);
        try{
            Map<String, Object> tokenInfo = securityRemoteClient.postAccessToken(parameters);
            removeUserPermissionInfo(tokenInfo);
            return new ResultData(tokenInfo);
        }catch (FeignException e){
            String message = e.getMessage();
            JSONObject jsonObject = new JSONObject(message.substring(message.indexOf("{")));
            return CustomThrow.throwCustom(jsonObject.toString());
        }
    }

    @PostMapping("/suibuaa/refresh_token_system")
    public ResultData refresh_token_system(String refresh_token) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(OAuth2Utils.GRANT_TYPE, "refresh_token");
        parameters.put(OAuth2Utils.CLIENT_ID, HealthcareClientInfo.SYSTEM_CLIENT_ID);
        parameters.put("client_secret", HealthcareClientInfo.SYSTEM_CLIENT_SECRET);
        parameters.put(OAuth2Utils.SCOPE, HealthcareClientInfo.SYSTEM_CLIENT_SCOPE);
        parameters.put("refresh_token", refresh_token);
        try{
            Map<String, Object> tokenInfo = securityRemoteClient.postAccessToken(parameters);
            removeUserPermissionInfo(tokenInfo);
            return new ResultData(tokenInfo);
        }catch (FeignException e){
            String message = e.getMessage();
            JSONObject jsonObject = new JSONObject(message.substring(message.indexOf("{")));
            return CustomThrow.throwCustom(jsonObject.toString());
        }
    }

    private void removeUserPermissionInfo(Map<String, Object> tokenInfo) {
        if (tokenInfo != null && tokenInfo.containsKey("currentLoginUser")) {
            ((Map) tokenInfo.get("currentLoginUser")).remove("permissions");
            ((Map) tokenInfo.get("currentLoginUser")).remove("roles");
            ((Map) tokenInfo.get("currentLoginUser")).remove("password");
            ((Map) tokenInfo.get("currentLoginUser")).put("username",((Map) tokenInfo.get("currentLoginUser")).get("name"));
        }
    }
}
