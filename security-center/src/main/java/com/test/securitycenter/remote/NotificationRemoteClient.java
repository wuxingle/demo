package com.test.securitycenter.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("notification-center")
@RequestMapping(value = "/notify/v1")
public interface NotificationRemoteClient {

//    @PostMapping(value = "/checkVerificationCode")
//    ResultData<VerifyResultVo> checkVerificationCode(@RequestBody VerifyCodeVo verifyCodeVo);

}