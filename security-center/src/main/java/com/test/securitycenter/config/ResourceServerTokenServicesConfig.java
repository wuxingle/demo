package com.test.securitycenter.config;

import com.common.apicommon.utils.HttpURLConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.oauth2.resource.DefaultUserInfoRestTemplateFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.util.List;

@Slf4j
@Configuration
public class ResourceServerTokenServicesConfig {

    @Bean
    @Primary
    public UserInfoRestTemplateFactory userInfoRestTemplateFactory(ObjectProvider<List<UserInfoRestTemplateCustomizer>> customizers, ObjectProvider<OAuth2ProtectedResourceDetails> details, ObjectProvider<OAuth2ClientContext> oauth2ClientContext) {
        UserInfoRestTemplateFactory factory = new DefaultUserInfoRestTemplateFactory(customizers, details, oauth2ClientContext);
        try {
            CloseableHttpClient httpClient = HttpURLConnectionUtil.acceptsUntrustedCertsHttpClient();
            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            factory.getUserInfoRestTemplate().setRequestFactory(clientHttpRequestFactory);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return factory;
    }
}
