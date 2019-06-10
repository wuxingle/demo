package com.test.usercenter.service.impl;

import com.common.apicommon.security.HealthcareClientInfo;
import com.common.apicommon.utils.HttpURLConnectionUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;

public class CustomUserInfoTokenServices extends UserInfoTokenServices {

    public CustomUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
        super(userInfoEndpointUrl, clientId);
    }

    public void setRestTemplate(OAuth2RestOperations restTemplate) {
        super.setRestTemplate(restTemplate());
    }

    public OAuth2RestOperations restTemplate() {
        try {
            CloseableHttpClient httpClient = HttpURLConnectionUtil.acceptsUntrustedCertsHttpClient();
            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            BaseOAuth2ProtectedResourceDetails resource = new BaseOAuth2ProtectedResourceDetails();
            resource.setClientId(HealthcareClientInfo.MOBILE_CLIENT_ID);
            OAuth2RestTemplate te = new OAuth2RestTemplate(resource);
            te.setRequestFactory(clientHttpRequestFactory);
            return te;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
