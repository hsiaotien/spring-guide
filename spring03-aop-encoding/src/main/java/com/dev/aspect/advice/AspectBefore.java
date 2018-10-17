package com.dev.aspect.advice;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectBefore {
	
	public void before(JoinPoint jpoint){
		
		String role = "admin";//如果使用其他role,抛出异常,这就是权限管理.
		
		String name = jpoint.getSignature().getName();
		String name2 = jpoint.getTarget().getClass().getName();
		String name3 = jpoint.getThis().getClass().getName();
		/**
		 * 三个name的结果
		 * 	find/save
			com.dev.aspect.advice.UserServiceImpl / com.dev.aspect.advice.BookService
			com.sun.proxy.$Proxy14 / com.dev.aspect.advice.BookService$$EnhancerBySpringCGLIB$$73521f90
		 */
		System.out.println("方法名:"+name);
		System.out.println("目标对象类名"+name2);
		System.out.println("代理类对象类名"+name3);
		if("save".equals(name)){
			if(!"admin".equals(role)){
				throw new RuntimeException("你的权限不够,请升级权限");
			}
		}
	}
}
