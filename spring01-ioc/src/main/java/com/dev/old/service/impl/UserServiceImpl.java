package com.dev.old.service.impl;

import com.dev.old.dao.IUserDao;
import com.dev.old.dao.impl.UserDaoImpl;
import com.dev.old.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public void findUserByUsernameAndPassword() {
		System.out.println("最原始的三层结构-service层");
		IUserDao userDao = new UserDaoImpl();
		userDao.findUserByUsernameAndPassword();
	}

}
