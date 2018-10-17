package com.dev.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value="consumerDao")
@Repository(value="consumerDao")
public class ConsumerDao {
	
	public void show(){
		System.out.println("ConsumerDao的show调用了");
	}
}
