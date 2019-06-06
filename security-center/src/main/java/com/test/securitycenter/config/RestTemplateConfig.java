package com.test.securitycenter.config;

//@Configuration
public class RestTemplateConfig {

//    @Bean
//    @Primary
//    public ResourceServerTokenServices userInfoTokenServices(){
//        CustomUserInfoTokenServices services = new CustomUserInfoTokenServices("https://hc-gateway:443/api-s/security/v1/getCurrentUserAuth", HealthcareClientInfo.MOBILE_CLIENT_ID);
//        services.setRestTemplate(restTemplate());
//        return services;
//    }

//    @Bean
//    public OAuth2RestOperations restTemplate(){
//        try {
//            CloseableHttpClient httpClient = acceptsUntrustedCertsHttpClient();
//            HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//            BaseOAuth2ProtectedResourceDetails resource = new BaseOAuth2ProtectedResourceDetails();
//            resource.setClientId(HealthcareClientInfo.MOBILE_CLIENT_ID);
//            OAuth2RestTemplate te = new OAuth2RestTemplate(resource);
//            te.setRequestFactory(clientHttpRequestFactory);
//            return te;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}