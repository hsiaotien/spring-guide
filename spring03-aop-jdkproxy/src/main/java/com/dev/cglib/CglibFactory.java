package com.dev.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibFactory implements MethodInterceptor{

	private ProductService productService;
	
	public CglibFactory(ProductService productService) {
		this.productService=productService;
	}
	
	public Object getCglibObeject(){
		
		//获取代理生成器
		Enhancer enhancer = new Enhancer();
		//在增强器上设置两个属性
		//设置要生成代理对象的目标对象：生成的目标对象类型的子类型
		enhancer.setSuperclass(productService.getClass());
		//增强(设置回调函数),扩展实现方法拦截器,在实现方法中写增强代码
		enhancer.setCallback(this);
		
		return enhancer.create();
	}
	
	@Override
	//回调方法（代理对象的方法）
		//参数1：代理对象
		//参数2：目标对象的方法对象
		//参数3：目标对象的方法的参数的值
		//参数4：代理对象的方法对象
	public Object intercept(Object proxy, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		if("save".equals(arg1.getName())){
			writeLog();
		}
		Object object = arg1.invoke(productService, arg2);
		return object;
	}

	private void writeLog() {
		System.out.println("cglib代理没有接口的类, 写日志了");
	}
	
}
