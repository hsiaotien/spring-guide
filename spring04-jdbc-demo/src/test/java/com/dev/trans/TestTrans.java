package com.dev.trans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestTrans {
	
	@Autowired
	private ITransService transService;
	
	@Test
	public void test() {
		transService.trans("tom", "jack", 1000d);
	}
	/**
	 * 分析, 上述转账过程使用了ioc技术,将对象的创建交给spring管理. 
	 * 使用了jdbctemplate技术,dao层通过继承的jdbcdaosupport方式,通过配置数据源,实例化父类的模板对象,但可以调用父类的获取jdbc模板对象方法,
	 * 获取模板对象,完成数据库的操作
	 * 
	 * 这里存在一个问题,当事务中两条操作数据库的方法中发生异常,会出现数据库安全问题. 需要引入事务管理
	 * 方案1. 传统的事务管理方式, 在业务代码中,添加事务管理代码, 具有侵入性, 违背开发的开闭原则
	 * 
	 * 方案2. 使用aop 切面编程技术,通过代理的方式,引入事务管理的功能实现
	 * 使用XML或注解配置声明式事务
	 * Spring的声明式事务是通过AOP实现的（环绕通知）
	 * 在开发中经常使用（代码侵入性最小）--推荐使用！

	 */
}
