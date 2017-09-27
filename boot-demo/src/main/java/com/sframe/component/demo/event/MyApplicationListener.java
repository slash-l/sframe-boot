package com.sframe.component.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description 定义一个监听器
 * @date 2017/3/6 2017, 下午9:46
 */
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("接受到事件：" + event.getClass());
    }

}
