package com.test.securitycenter.config;

import cn.hutool.json.JSONObject;
import com.common.apicommon.model.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Slf4j
@Component("customResponseException")
public class CustomResponseException implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) throws Exception {
//        Throwable[] causeChain = throwableAnalyzer.determineCauseChain(e);
//        OAuth2Exception ase = (OAuth2Exception) throwableAnalyzer.getFirstThrowableOfType(OAuth2Exception.class, causeChain);
//        int errorCode = ase.getHttpErrorCode();
        JSONObject object = new JSONObject();
        object.put("code", ResultStatus.FAIL.code()+"");
        object.put("message", e.getMessage());
        return new ResponseEntity(object, HttpStatus.valueOf(400));
    }
}
