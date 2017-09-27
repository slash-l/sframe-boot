package com.sframe.component.common.util.locale;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/7/4 2017, 上午12:14
 */
@Slf4j
@NoArgsConstructor
public class LocaleUtil {

    /**
     * 获取当前区域语言
     * <p>从spring session 获取，如果获取失败，默认获取中文</p>
     * @return
     */
    public static Locale getRequestLocale(){
        Locale locale ;
        try {
            HttpServletRequest request = getRequest();
            if(request == null){
                return Locale.CHINESE;
            }
            locale = request.getLocale();
            if(locale == null){
                locale = Locale.CHINESE;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            locale = Locale.CHINESE;
        }
        return locale;
    }

    /**
     * 获取 HttpServletRequest
     * @return
     */
    public static HttpServletRequest getRequest(){
        if(RequestContextHolder.getRequestAttributes() != null){
            return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        }else{
            return null;
        }
    }

    /**
     * 根据语言获取 Lacale
     * @param language
     * @return
     */
    public static Locale getLanguageLocale(String language){
        if(StringUtils.isEmpty(language)){
            return Locale.CHINESE;
        }
        return Locale.forLanguageTag(language);
    }

}
