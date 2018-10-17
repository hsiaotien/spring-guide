package com.dev.aspect.extra;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//-->相当于aop:aspect ref=""
public class MyAspect {
	
	/*
	 * 切入点的第二种确定方式
	 * //自定义切入点
	//方法名就是切入点的名字-->不仅仅是方法名,要括号
	//相当于<aop:pointcut expression="bean(*Service)" id="myPointcut2"/>
	 */
	@Pointcut("bean(bookService)")
	public void myPointCut1() {}
	@Pointcut("bean(userService)")
	public void myPointCut2() {}
	
	@Before("myPointCut1() || myPointCut2()")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知,目标类:"+joinPoint.getTarget().getClass().getName()+",类的代理类:"
				+joinPoint.getThis().getClass().getName()+",方法:"+joinPoint.getSignature().getName());
	}
}
