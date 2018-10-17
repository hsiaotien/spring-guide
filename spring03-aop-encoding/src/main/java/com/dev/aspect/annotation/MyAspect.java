package com.dev.aspect.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 通过注解来完成 各种类型的通知
 * @author HsiaotienPc
 *
 */

@Component("myAspect")
@Aspect
public class MyAspect {

	//@Before("bean(*Service)")//-->前置通知
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"方法,的前置通知");
	}
	
	//@AfterReturning(value="bean(*Service)",returning="returnVal")//-->后置通知
	public void afterReturning(JoinPoint joinPoint, Object returnVal) {
		System.out.println(joinPoint.getSignature().getName()+"方法,的后置通知,返回结果"+returnVal);
	}
	
	//@Around("bean(*Service)")//-->环绕通知
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(proceedingJoinPoint.getSignature().getName()+"方法被环绕");
		Object resultObject = proceedingJoinPoint.proceed();
		System.out.println(proceedingJoinPoint.getThis().getClass().getName()+":代理类的面目");
		System.out.println(resultObject+":返回的结果,什么??");
		return resultObject;
	}
	
	@AfterThrowing(value="bean(*Service)",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Throwable ex) {
		System.out.println(joinPoint.getTarget().getClass().getName()+"目标类的方法:"
				+joinPoint.getSignature().getName()+"抛出了异常:"+ex.getMessage());
	}
	@After(value="bean(*Service)")
	public void after(JoinPoint joinPoint) {
		
		System.out.println(joinPoint.getTarget().getClass().getName()+"目标类的方法:"
				+joinPoint.getSignature().getName()+"可能有异常, 但不管如何,占用的资源要close");
	}
}

