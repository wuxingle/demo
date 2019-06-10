package com.test.securitycenter.controller;

import com.common.apicommon.model.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/security/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/getCurrentUserAuth")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/user")
    public Principal getUser(Principal user) {
        return user;
    }

    @DeleteMapping(value = "/remove_token", params = "access_token")
    public ResultData removeToken(String access_token) {
        Boolean b= consumerTokenServices.revokeToken(access_token);
        return new ResultData<>(b);
    }
}
