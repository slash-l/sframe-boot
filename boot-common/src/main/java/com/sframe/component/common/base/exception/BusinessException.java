package com.sframe.component.common.base.exception;

import com.sframe.component.common.util.locale.LocaleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/20 2017, 下午10:59
 */
@Component
public class BusinessException extends Exception {

    @Autowired
    private MessageSource messageSource;

    private Serializable extraObject;

    public BusinessException() {
        super();
    }

    public BusinessException(String exceptionCode) {
        super(exceptionCode);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Serializable getExtraObject() {
        return extraObject;
    }

    public void setExtraObject(Serializable extraObject) {
        this.extraObject = extraObject;
    }
}
