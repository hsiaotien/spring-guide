package com.dev.aspect.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-annotation.xml")
public class TestAspectAnnotation {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void test() {
		
		userService.save();
		userService.find();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~`");
		bookService.save();
		bookService.find();
	}
}
