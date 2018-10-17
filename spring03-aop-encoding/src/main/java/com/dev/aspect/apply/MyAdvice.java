package com.dev.aspect.apply;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	
	public void before(JoinPoint joinPoint) {
		//获取签名名称
		String methodName = joinPoint.getSignature().getName();
		//假设用户的role
		String role = "admin";
		if ("save".equals(methodName)) {
			if("admin".equals(role)) {
				System.out.println("role值为admin, save方法被调用了");
			} else {
				throw new RuntimeException("该role没有访问权限....");
			}
		}
	}
	
	public void afterReturn(JoinPoint joinPoint, Object returnVal) {
		
		System.out.println("发送短信,显示余额为:"+returnVal);
	}
	
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("开启事务");
		Object resultobject = proceedingJoinPoint.proceed();
		System.out.println("提交事务");
		return resultobject;
	}
	
	public void afterThrowing(JoinPoint joinPoint,Throwable ex) {
		
		System.out.println(joinPoint.getTarget().getClass()+"类的"+joinPoint.getSignature().getName()+"方法抛出了异常,异常信息:"+ex.getMessage());
	}
	
	public void after(JoinPoint joinPoint) {
		
		System.out.println("当前连接对象(无论是否异常,相当于finally)关闭..调用的方法是"+joinPoint.getSignature().getName());
	}
}
