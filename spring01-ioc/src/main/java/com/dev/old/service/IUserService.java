package com.dev.old.service;

public interface IUserService {
	/**
	 * 传统方式,三层结构高度耦合-->组合关系-->反射加组合关系-->工厂模式
	 */
	public void findUserByUsernameAndPassword();
}
