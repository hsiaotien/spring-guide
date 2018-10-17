package com.dev.old.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestOldAop {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testOldAop(){
		
		customerService.save();
		
		customerService.find();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		productService.save();
		
		productService.find();
	}
}
