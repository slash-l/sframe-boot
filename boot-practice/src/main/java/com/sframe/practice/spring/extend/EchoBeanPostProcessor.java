package com.sframe.practice.spring.extend;

import com.sframe.practice.spring.extend.bean.LogUser;
import com.sframe.practice.spring.extend.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author mumu
 * @vervion v1.0
 * @description BeanPostProcessor 会在每个 bean 初始化的时候调用一次
 * @date 2017/2/15 2017, 下午11:16
 */
@Component
public class EchoBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在 bean 依赖装配（属性设置完）完成之后触发
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " + bean.getClass());
        //对制定的类做了一些处理，返回代理类
        if(bean instanceof User){
            return new LogUser();
        }
        return bean;
    }

    /**
     * 在 bean init 方法执行之后触发
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization: " + bean.getClass());
        return bean;
    }
}
