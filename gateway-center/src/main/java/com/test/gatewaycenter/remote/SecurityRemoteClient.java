package com.test.gatewaycenter.remote;


import com.common.apicommon.model.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("security-center")
public interface SecurityRemoteClient {

    @PostMapping(path = "/oauth/token")
    Map<String, Object> postAccessToken(@RequestParam Map<String, String> parameters);

    @DeleteMapping(path = "/security/v1/remove_token")
    ResultData removeToken(@RequestParam("access_token") String access_token);
}
