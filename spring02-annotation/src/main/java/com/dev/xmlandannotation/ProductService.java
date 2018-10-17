package com.dev.xmlandannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProductService {
	
//	@Autowired//这个注解只根据类找,跟id/name无关
	@Autowired
	@Qualifier(value="product")//根据id/name找
	private ProductDao productDao;
	
	public void show(){
		System.out.println("productservice的show方法被调用了");
		productDao.show();
	}
}
