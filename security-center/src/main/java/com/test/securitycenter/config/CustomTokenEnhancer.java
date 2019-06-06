package com.test.securitycenter.config;

import com.common.apicommon.security.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        if (accessToken instanceof DefaultOAuth2AccessToken) {
            DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) accessToken;
            Authentication userAuthentication = authentication.getUserAuthentication();
            Object principal = userAuthentication.getPrincipal();
            if (principal instanceof LoginUser) {
                LoginUser loginUser = (LoginUser) principal;
                Map<String, Object> map = new HashMap<>(defaultOAuth2AccessToken.getAdditionalInformation());
                map.put("currentLoginUser", loginUser);
                defaultOAuth2AccessToken.setAdditionalInformation(map);
            }
        }
        return accessToken;
    }
}
