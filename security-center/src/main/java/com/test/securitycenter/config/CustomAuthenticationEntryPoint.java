package com.test.securitycenter.config;

import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.common.apicommon.model.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component("customAuthenticationEntryPoint")
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        try {
            if (httpServletResponse != null) {
                httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
                PrintWriter writer = httpServletResponse.getWriter();
                if (writer != null) {
                    JSONObject object = new JSONObject();
                    object.put("code", ResultStatus.FAIL.code()+"");
                    object.put("message", "无效Token");
                    writer.write(JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect));
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            log.error(e1.toString());
        }
    }
}
