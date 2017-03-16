package com.sframe.component.demo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/6 2017, 下午10:34
 */
@Component
public class MyEventHandle {

    /**
     * 参数任意
     * 所有，该参数事件，或者其子事件（子类）都可以接收到
     * @param event
     */
    @EventListener
    public void event(Object event){
        System.out.println("MyEventHandle 接收到事件：" + event.getClass());
    }
}
