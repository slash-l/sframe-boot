package com.sframe.component.common.base.service;

import com.sframe.component.common.base.constant.ResponseOutvoCode;
import com.sframe.component.common.base.outvo.ResponseOutvo;
import com.sframe.component.common.util.locale.LocaleUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author mumu
 * @vervion v1.0
 * @description 统一后端接口返回的操作类
 * @date 2017/7/3 2017, 下午11:43
 */
@Slf4j
@Component
public class ResponseService {

    @Autowired
    private MessageSource messageSource;

/////////////////////////////   返回成功

    public <T> ResponseOutvo<T> getSuccess() {
        return new ResponseOutvo<>(ResponseOutvoCode.SUCCESS.name(), getMessage(ResponseOutvoCode.SUCCESS.name()));
    }

    public <T> ResponseOutvo<T> getSuccess(T outvo) {
        return new ResponseOutvo<>(ResponseOutvoCode.SUCCESS.name(), getMessage(ResponseOutvoCode.SUCCESS.name()), outvo);
    }

    public ResponseOutvo<String> getSuccess(String outvo) {
        return new ResponseOutvo<>(ResponseOutvoCode.SUCCESS.name(), getMessage(ResponseOutvoCode.SUCCESS.name()), outvo);
    }

/////////////////////////////   返回失败

    public <T> ResponseOutvo<T> getError(String code, Object ... message) {
        return new ResponseOutvo<>(code, getMessage(code, message), null);
    }

    public <T> ResponseOutvo<T> getError(String code) {
        String message = "";
        try {
            message = getMessage(code);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            message = code;
        }
        return new ResponseOutvo<>(code, message);
    }

    public <T> ResponseOutvo<T> getError(String code, String... params) {
        return new ResponseOutvo<>(code, getMessage(code, params));
    }

    public <T> ResponseOutvo<T> querySysError() {
        return new ResponseOutvo<>(ResponseOutvoCode.SYSTEM_ERROR.name(), getMessage(ResponseOutvoCode.SYSTEM_ERROR.name()));
    }

////////////////////////////    获取国际化文言

    public String getMessage(String code) {
        Locale locale = LocaleUtil.getRequestLocale();
        return messageSource.getMessage(code, null, code, locale);
    }

    public String getMessage(String code, Object[] params) {
        Locale locale = LocaleUtil.getRequestLocale();
        return messageSource.getMessage(code, params, code, locale);
    }

    public String getMessage(String code, Object[] params, Locale locale) {
        return messageSource.getMessage(code, params, locale);
    }

    public String getMessage(String code, Object[] params, String userLanguage) {
        Locale locale = LocaleUtil.getLanguageLocale(userLanguage);
        return messageSource.getMessage(code, params, locale);
    }

}
