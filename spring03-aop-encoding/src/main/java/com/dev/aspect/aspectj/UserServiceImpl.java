package com.dev.aspect.aspectj;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("UserServiceImpl保存了");
	}

	@Override
	public void find() {
		System.out.println("UserServiceImpl查找了");
	}

}
