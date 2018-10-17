package com.dev.old.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class TimeLogIntercept implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
	
		long begin = System.currentTimeMillis();
		Object object = invocation.proceed();
		long end = System.currentTimeMillis();
		
		System.out.println(invocation.getThis().getClass().getName()+"类的"+invocation.getMethod().getName()+"方法运行时间差(millis):"+(end-begin));
		
		return object;
	}

}
