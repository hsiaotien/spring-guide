package com.dev.xmlandannotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class xmlAndAnnotationTest {
	
	@Test
	public void testMixed(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-mixed.xml");
		ProductService productService = (ProductService) applicationContext.getBean("productService");
		productService.show();
	}
}
