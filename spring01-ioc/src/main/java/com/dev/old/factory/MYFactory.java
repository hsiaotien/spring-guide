package com.dev.old.factory;

import com.dev.old.dao.IUserDao;
import com.dev.old.dao.impl.UserDaoImpl;
import com.dev.old.service.IUserService;
import com.dev.old.service.impl.UserServiceImpl;

public class MYFactory {
	/**
	 * 我的工厂模式: 类名耦合
	 * 通过工厂模式提供对象,解决了层与层的耦合,但类名耦合,不能动态
	 * @return
	 */
	private IUserService getService(){
		
		return new UserServiceImpl();
	}
	private IUserDao getDao(){
		
		return new UserDaoImpl();
	}
	
	/**
	 * 反射+工厂+组合关系
	 * @return
	 */
	public Object getBean(){
	
		Object obj = null;
		try {
			obj = Class.forName("com.dev.old.dao.impl.UserDaoImpl").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
