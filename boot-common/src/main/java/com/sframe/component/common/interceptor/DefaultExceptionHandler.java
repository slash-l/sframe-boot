package com.sframe.component.common.interceptor;

import com.sframe.component.common.base.constant.ResponseOutvoCode;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.common.base.service.ResponseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;

/**
 * @author mumu
 * @vervion v1.0
 * @description 统一 controller exception 返回 系统错误
 * @date 2017/7/8 2017, 下午11:36
 */
@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    @Resource
    private ResponseService responseService;

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseOutvo conversionErrorHandler(Exception ex) {
        //记录日志
        log.error(ex.getMessage(), ex);
        return responseService.getError(ResponseOutvoCode.SYSTEM_ERROR.name());
    }

}
