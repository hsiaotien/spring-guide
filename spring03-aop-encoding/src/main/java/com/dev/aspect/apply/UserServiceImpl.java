package com.dev.aspect.apply;

public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("UserServiceImpl保存");
//		double i = 1/0;//测试异常通知
	}

	@Override
	public double find() {
		System.out.println("UserServiceImpl查询");
		return 5.20;
	}

}
