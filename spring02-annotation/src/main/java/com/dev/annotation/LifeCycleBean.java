package com.dev.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component(value="LifeCycle")//相当于bean id=..
public class LifeCycleBean {

	public LifeCycleBean() {
		super();
		System.out.println("LifeCycleBean空参构造调用");
	}
	
	public void show(){
		System.out.println("LifeCycleBean的show方法调用");
	}
	@PostConstruct//相当于init-method (xml的初始化方法)
	public void init(){
		System.out.println("LifeCycleBean的初始化方法被调用");
	}
	@PreDestroy//相当于destroy-method(xml的销毁方法)
	public void destroy(){
		System.out.println("LifeCycleBean的销毁方法被调用");
	}
}
