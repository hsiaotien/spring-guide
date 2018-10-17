package com.dev.aspect.advice;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("UserServiceImpl保存");
	}

	@Override
	public void find() {
		System.out.println("UserServiceImpl查询");
	}

}
