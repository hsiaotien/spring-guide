package com.dev.ioc.factory;

import com.dev.ioc.dao.impl.OrderDaoImpl;

public class StaticFactory {
	
	
	
	public StaticFactory() {
		super();
		System.out.println("statci factory 初始化了");
	}

	public static OrderDaoImpl getOrderDao(){
		
		return new OrderDaoImpl();
	}
}
