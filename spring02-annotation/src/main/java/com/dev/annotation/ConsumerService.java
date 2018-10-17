package com.dev.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 使用注解的方式
 */
//@Component(value="consumerService")
@Service(value="consumerService")
public class ConsumerService {
	@Value(value="rose")
	private String name;//注意如果该属性有初始化值,会被注解覆盖, 原因:先有显示初始化,再有实例初始化,后者覆盖前者
	/**
	 * 传统方式用xml, 底层IOC和 DI技术
	 */
	//@Value(value="#{consumerDao}")  //第一种
	//@Autowired//类似xml依赖注入setter//第二种,有三种情况可以属性注入
	/*@Autowired
	@Qualifier("consumerDao")*/
	
//	@Resource
	@Resource(name="consumerDao")
	private ConsumerDao consumerDao;
	
	/*public void setConsumerDao(ConsumerDao consumerDao) {
		this.consumerDao = consumerDao;
	}*/

	public void show(){
		System.out.println("ConsumerService的show调用了");
		consumerDao.show();
	}
	
	public void showName(){
		System.out.println("name:"+name);
	}
}
