//package com.test.usercenter.config;
//
//import org.springframework.security.oauth2.client.OAuth2RestOperations;
//import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//
//public class RestTemplateConfig {
//
//    public ResourceServerTokenServices userInfoTokenServices(){
//        CustomUserInfoTokenServices services = new CustomUserInfoTokenServices("https://hc-gateway:443/api-s/security/v1/getCurrentUserAuth", HealthcareClientInfo.MOBILE_CLIENT_ID);
//        services.setRestTemplate(restTemplate());
//        return services;
//    }
//
//    public OAuth2RestOperations restTemplate(){
//        try {
////            CloseableHttpClient httpClient = acceptsUntrustedCertsHttpClient();
////            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//            BaseOAuth2ProtectedResourceDetails resource = new BaseOAuth2ProtectedResourceDetails();
//            resource.setClientId(HealthcareClientInfo.MOBILE_CLIENT_ID);
////            OAuth2RestTemplate te = new OAuth2RestTemplate(resource);
////            te.setRequestFactory(clientHttpRequestFactory);
////            return te;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}