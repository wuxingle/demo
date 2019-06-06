package com.test.usercenter.config;

import cn.hutool.json.JSONObject;
import com.common.apicommon.model.ResultStatus;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("execution(* com.test.usercenter.controller.*.*(..))")
    private void pointcut() {
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void handleThrowing(Exception e) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        try {
            if (response != null) {
                response.reset();
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                if (writer != null) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("code", ResultStatus.FAIL.code());
                    map.put("message", "系统错误,请稍候再试");
                    JSONObject jsonObject = new JSONObject(map);
                    writer.print(jsonObject.toString());
                    writer.flush();
                    writer.close();
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
