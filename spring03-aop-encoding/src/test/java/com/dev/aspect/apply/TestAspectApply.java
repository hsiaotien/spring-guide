package com.dev.aspect.apply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 通知类型, before |  afterReturning | arroud | afterThrowing | afters
 * @author HsiaotienPc
 * 将各种通知(增强)写在一个类中的不同方法中
 * 
 * 目标对象分两种: 一种有接口的类, 一种没有接口的类
 * 
 * 配置xml, 可以并行配置
 */
//配置注解
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-apply.xml")
public class TestAspectApply {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Autowired
	@Qualifier("checkFee")
	private CheckFee checkFee;
	
	@Test
	public void testBefore() {
		//before 
		userService.save();
		userService.find();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		bookService.save();
		bookService.find();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//after-returning
		checkFee.checkFee();
		
	}
	
	
}
