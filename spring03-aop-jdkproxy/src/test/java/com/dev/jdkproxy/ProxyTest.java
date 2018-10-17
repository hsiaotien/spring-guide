package com.dev.jdkproxy;


import org.junit.Test;

public class ProxyTest {
	
	@Test
	public void testJdkProxy(){
		
		ICustomerService customerService = new CustomerServiceImpl();
		//匿名实现类(本质匿名对象),封装增强代码
//		JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(customerService);
		//匿名内部类,封装增强代码
//		JdkProxyFactory02 jdkProxyFactory = new JdkProxyFactory02(customerService);
		//最逼格的写法, 扩展工厂的方式
		JdkProxyFactory03 jdkProxyFactory = new JdkProxyFactory03(customerService);
		ICustomerService proxyObject = (ICustomerService) jdkProxyFactory.getProxyObject();
		proxyObject.save();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		proxyObject.find();
	}
}
