package com.sframe.component.common.base.outvo;

import com.sframe.component.common.util.locale.LocaleUtil;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mumu
 * @vervion v1.0
 * @description 接口返回统一 outvo
 * @date 2017/7/3 2017, 下午11:31
 */
@Data
public class ResponseOutvo<T> {

    /**
     * 接口处理时长（单位：毫秒）
     */
    private long processTime;

    /**
     * 结果状态码
     */
    private String code;

    /**
     * 结果信息
     */
    private String message;

    /**
     * 结果实体
     */
    private T outvo;

    public ResponseOutvo(String code, String message){
        this(code, message, null);
    }

    public ResponseOutvo(String code, String message, T outvo){
        this.code = code;
        this.message = message;
        this.outvo = outvo;
        this.processTime = System.currentTimeMillis() - this.getStartTime();
    }

    /**
     * 获取请求接口时的开始时间
     * @return
     */
    private long getStartTime(){
        HttpServletRequest req = LocaleUtil.getRequest();
        if(req != null && req.getAttribute("startTime") != null){
            return (long)req.getAttribute("startTime");
        }else{
            return System.currentTimeMillis();
        }
    }

}
