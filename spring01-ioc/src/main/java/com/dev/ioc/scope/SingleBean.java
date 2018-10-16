package com.dev.ioc.scope;

public class SingleBean {
	
	public SingleBean() {
		super();
		System.out.println("SingleBean初始化了");
	}

	public void show(){
		System.out.println("SingleBean的show方法调用了");
	}
}
