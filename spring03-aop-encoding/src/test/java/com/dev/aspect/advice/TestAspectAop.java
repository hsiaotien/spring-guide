package com.dev.aspect.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-aspect.xml")
public class TestAspectAop {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BookService bookService;
	@Test
	public void testAop(){
		//可以看到代理类的名称,一个是jdk的动态代理
//		userService.save();
//		
//		userService.find();
		//一个是cglib方式的动态代理
		
		bookService.save();
		
		bookService.find();
	}
}
