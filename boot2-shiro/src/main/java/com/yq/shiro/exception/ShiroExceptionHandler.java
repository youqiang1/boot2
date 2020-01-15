package com.yq.shiro.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> shiro异常处理</p>
 * @author youq  2020/1/15 11:15
 */
@Slf4j
@ControllerAdvice
public class ShiroExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public String errorHandler(AuthorizationException e) {
        log.error("权限验证失败：", e);
        return "没有通过权限验证";
    }

}
