package com.dev.ioc.service.impl;


import com.dev.ioc.dao.IOrderDao;
import com.dev.ioc.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao;

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void queryOrder() {
		System.out.println("order-service层方法被调用了");

		orderDao.queryOrder();
	}

	// 添加空参构造方法用于测试applicationContext的非延迟加载
	public OrderServiceImpl() {
		super();
		System.out.println("order-service层对象初始化了");
	}
}
