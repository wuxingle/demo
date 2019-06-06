package com.test.securitycenter.config;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.common.apicommon.model.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("customAccessHandler")
public class CustomAccessHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        try {
            if (httpServletResponse != null) {
                httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
               JSONObject object = new JSONObject();
                object.put("code", ResultStatus.FAIL.code()+"");
                object.put("message", "用户权限不足");
                httpServletResponse.getWriter().write(JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect));
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            log.error(e1.toString());
        }
    }
}
