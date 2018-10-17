package com.dev.cglib;

import org.junit.Test;

public class CglibTest {
	
	@Test
	public void testCglib(){
		ProductService productService = new ProductService();
		CglibFactory cglibFactory = new CglibFactory(productService);
		ProductService cglibObeject = (ProductService) cglibFactory.getCglibObeject();
		cglibObeject.save();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		cglibObeject.find();
	}
}
