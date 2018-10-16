package com.dev.ioc.factory;

import com.dev.ioc.dao.impl.OrderDaoImpl;

public class InsFactory {
	
	public InsFactory() {
		super();
		System.out.println("ins factory 初始化了");
	}
	public OrderDaoImpl getOrderDaoImpl(){
		
		return new OrderDaoImpl();
	}
}
