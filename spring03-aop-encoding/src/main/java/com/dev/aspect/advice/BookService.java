package com.dev.aspect.advice;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	public void save(){
		System.out.println("cglib代理 save");
	}
	public void find(){
		System.out.println("cglib代理  find");
	}
}
