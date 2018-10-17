package com.dev.aspect.annotation;

import org.springframework.stereotype.Service;

@Service("bookService")
public class BookService {

	public void save(){
		System.out.println("cglib代理 save");
	}
	public int find(){
		System.out.println("cglib代理  find");
		return 99;
	}
}
