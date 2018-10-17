package com.dev.jdkproxy;

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
