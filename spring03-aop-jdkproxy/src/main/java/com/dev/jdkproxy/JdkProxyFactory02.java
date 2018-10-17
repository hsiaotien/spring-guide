package com.dev.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory02 {
	//factory01使用的是匿名实现类对象方式 封装增强代码
	public class MyInvocationHander implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if("save".equals(method.getName())){
				System.out.println("工厂2方式写日志,内部类方式");
			}
			Object object = method.invoke(customerService, args);
			return object;
		}
	}

	private ICustomerService customerService;
	
	public JdkProxyFactory02(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	public Object getProxyObject(){
		
		Object proxyInstance = Proxy.newProxyInstance(customerService.getClass().getClassLoader(), customerService.getClass().getInterfaces(), new MyInvocationHander());
		
		return  proxyInstance;
	}
}
