package com.dev.web;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

	public void sayHi(){
		System.out.println("hi,helloservice的sayHi方法被调用了");
	}
}
