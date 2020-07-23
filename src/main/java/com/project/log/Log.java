package com.project.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
/**
 * @description 类(或接口)是日志
 * @author  haojiaxing
 * @date   2020/7/23 10:40
 **/
public class Log implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getClassLoader()+"的====="+method.getName()+"执行======");
    }
}
