package com.test.securitycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableAuthorizationServer
public class SecurityCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityCenterApplication.class, args);
    }

}
