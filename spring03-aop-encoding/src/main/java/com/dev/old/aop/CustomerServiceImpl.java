package com.dev.old.aop;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void save() {
		System.out.println("CustomerServiceImpl保存了");
	}

	@Override
	public void find() {
		System.out.println("CustomerServiceImpl查找了");
	}
}
