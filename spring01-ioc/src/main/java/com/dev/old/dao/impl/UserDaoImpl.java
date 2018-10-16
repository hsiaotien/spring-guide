package com.dev.old.dao.impl;

import com.dev.old.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
	@Override
	public void findUserByUsernameAndPassword() {
		System.out.println("最原始的三层结构-dao层被调用了");
	}
}
