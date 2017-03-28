package com.sframe.component.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mumu
 * @vervion v1.0
 * @description
 * @date 2017/3/27 2017, 下午11:34
 */
@Aspect
@Component
public class LogAspect {

    @Before("execution(* com.sframe.component.demo.aop..*.*(..))")
    public void logBefore() {
        System.out.println("before method log done ");
    }

    @After("execution(* com.sframe.component.demo.aop..*.*(..))")
    public void logAfter(JoinPoint point){
        System.out.println("after method log done" + point.getTarget().getClass() + ",args=" + Arrays.asList(point.getArgs())+ ",method="+point.getSignature().getName());
    }

}
