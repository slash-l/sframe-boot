package com.sframe.component.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author mumu
 * @vervion v1.0
 * @description 定义事件
 * @date 2017/3/6 2017, 下午9:43
 */
public class MyApplicationEvent extends ApplicationEvent {

    public MyApplicationEvent(Object source) {
        super(source);
    }
}
