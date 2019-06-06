package com.test.gatewaycenter.remote;


import com.common.apicommon.model.ResultData;
import com.common.apicommon.security.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-center")
@RequestMapping(value = "/user/v1")
public interface UserRemoteClient {

    @GetMapping(value = "/getUserByPhoneNo", params = {"phoneNo"})
    ResultData<LoginUser> getUserByPhoneNo(@RequestParam("phoneNo") String phoneNo);

    @GetMapping(value = "/internal/getUserByName", params = {"name"})
    ResultData<LoginUser> getUserByName(@RequestParam("name") String name);

}
