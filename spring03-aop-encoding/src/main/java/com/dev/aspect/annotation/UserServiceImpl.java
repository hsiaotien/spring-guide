package com.dev.aspect.annotation;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("UserServiceImpl,jdk保存");
		double i = 1/0;//测试异常通知
	}

	@Override
	public double find() {
		System.out.println("UserServiceImpl,jdk查询");
		return 5.20;
	}

}
