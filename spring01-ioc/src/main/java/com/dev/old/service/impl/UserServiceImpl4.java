package com.dev.old.service.impl;

import com.dev.old.dao.IUserDao;
import com.dev.old.factory.MYFactory;
import com.dev.old.service.IUserService;

public class UserServiceImpl4 implements IUserService {
	
	@Override
	public void findUserByUsernameAndPassword() {
		System.out.println("最原始的三层结构-service层");
		/**
		 * 采用IoC（Inverse of Control，控制反转）的思想解决代码耦合问题。
		   简单的说就是引入工厂（第三者），将原来在程序中手动创建管理的依赖的UserDaoImpl对象，交给工厂来创建管理。
		 */
		
		//下面是通过工厂获取userDao对象, 用了反射加组合关系,完善工厂获取对象的方法,解决了层层耦合和类名的耦合
		IUserDao userDao = (IUserDao) new MYFactory().getBean();
		
		userDao.findUserByUsernameAndPassword();
	}

}
