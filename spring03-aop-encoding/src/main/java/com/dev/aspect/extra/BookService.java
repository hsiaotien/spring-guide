package com.dev.aspect.extra;

import org.springframework.stereotype.Component;

@Component("bookService")
public class BookService {

	public void save(){
		System.out.println("cglib代理 save");
	}
	public int find(){
		System.out.println("cglib代理  find");
		return 99;
	}
}
