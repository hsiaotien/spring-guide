package com.dev.aspect.aspectj;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public class BookService {
	
	public  void save(){
		System.out.println("BookService保存了");
	}
	
	public void find(){
		System.out.println("BookService查找了");
	}
}
