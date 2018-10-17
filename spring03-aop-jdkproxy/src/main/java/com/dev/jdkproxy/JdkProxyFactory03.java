package com.dev.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory03 implements InvocationHandler{
	
	private ICustomerService customerService;
	
	public JdkProxyFactory03(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	public Object getProxyObject(){
		
		Object proxyInstance = Proxy.newProxyInstance(customerService.getClass().getClassLoader(), customerService.getClass().getInterfaces(), this);
		
		return  proxyInstance;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//增强代码
		if("save".equals(method.getName())){
			System.out.println("扩展工厂的方式,来实现增强代码的封装. 写日志了...");
		}
		Object object = method.invoke(customerService, args);
		return object;
	}
}
