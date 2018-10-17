package com.dev.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//相当于bean id and class = ..类名小写
//@Scope
@Scope("prototype")
public class ScopeBean {

	public ScopeBean() {
		super();
		System.out.println("ScopeBean的空参构造函数调用了,即实例被初始化了");
	}
}
