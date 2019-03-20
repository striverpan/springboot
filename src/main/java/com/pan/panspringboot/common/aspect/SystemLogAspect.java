package com.pan.panspringboot.common.aspect;

import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {


    @Pointcut("@annotation(com.pan.panspringboot.common.aspect.SystemControllerLog)")
    public void controllerAspect() { }

    @Pointcut("@annotation(com.pan.panspringboot.common.aspect.SystemServiceLog)")
    public void serviceAspect(){}

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);

        //操作名称
        String description = controllerLog.description();

        System.out.println(description);

        //Todo 记录用户信息 加上操作名称 完成日志审计功能
        //System.out.println(discription);


    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("xx2");
    }



}
