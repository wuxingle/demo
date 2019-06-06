package com.test.securitycenter.config;


import com.common.apicommon.security.HealthcareClientInfo;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

public class OauthConfiguration {

    ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri("http://gateway-center:8992/api-s/oauth/token");
        details.setClientId(HealthcareClientInfo.MOBILE_CLIENT_ID);
        details.setClientSecret(HealthcareClientInfo.MOBILE_CLIENT_SECRET);
        details.setGrantType("password");
        details.setAuthenticationScheme(AuthenticationScheme.valueOf("form"));
        return details;
    }

    public OAuth2RestTemplate oAuth2RestTemplate() {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails(), new DefaultOAuth2ClientContext());
        return restTemplate;
    }
}
