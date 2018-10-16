package com.dev.old.service.impl;


import com.dev.old.dao.IUserDao;
import com.dev.old.service.IUserService;

public class UserServiceImpl2 implements IUserService {
	
	private IUserDao userDao;
	
	public void setUserDao(IUserDao userDao){
		this.userDao=userDao;
	}

	@Override
	public void findUserByUsernameAndPassword() {
		System.out.println("最原始的三层结构-service层");
		userDao.findUserByUsernameAndPassword();
	}

}
