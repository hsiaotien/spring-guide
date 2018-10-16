package com.dev.ioc.dao.impl;

import com.dev.ioc.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public void queryOrder() {
		System.out.println("order-dao层被调用");
	}

	// 添加空参构造方法用于测试applicationContext的非延迟加载
	public OrderDaoImpl() {
		super();
		System.out.println("order-dao层对象初始化了");
	}

	/**
	 * 通过spring工厂，可以控制bean的生命周期。 通过 init-method属性 指定实例化后的调用方法 通过
	 * destroy-method属性 指定销毁对象前的方法 测试时查看控制台打印，发现销毁方法没有执行。
	 * 
	 * 提示：销毁方法的执行必须满足两个条件： 1） 单例（singleton）的bean才会可以手动销毁。 2）
	 * 必须手动关闭容器（调用close的方法）时，才会执行手动销毁的方法。
	 */
	public void init() {
		System.out.println("bean实例化后,就调用ini方法");
	}

	public void destroy() {
		System.out.println("bean销毁对象前的方法 ");
	}
}
