package com.dev.old.aop;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public class ProductService {
	
	public  void save(){
		System.out.println("ProductService保存了");
	}
	
	public void find(){
		System.out.println("ProductService查找了");
	}
}
