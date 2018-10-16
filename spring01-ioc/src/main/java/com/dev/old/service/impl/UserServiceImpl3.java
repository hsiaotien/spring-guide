package com.dev.old.service.impl;


import com.dev.old.dao.IUserDao;
import com.dev.old.service.IUserService;

public class UserServiceImpl3 implements IUserService {
	
	@Override
	public void findUserByUsernameAndPassword() {
		System.out.println("最原始的三层结构-service层");
		Class clazz = null;
		try {
			clazz = Class.forName("com.dev.old.dao.impl.UserDaoImpl");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		IUserDao userDao = null;
		try {
			userDao = (IUserDao) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		userDao.findUserByUsernameAndPassword();
	}

}
