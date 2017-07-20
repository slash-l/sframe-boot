package com.sframe.component.common.base.exception;

import java.io.Serializable;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/20 2017, 下午10:59
 */
public class BusinessException extends Exception {

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

}
