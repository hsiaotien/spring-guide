package com.dev.aspect.extra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * aop代理的选择, 默认的优先级是选择jdk动态代理(这是一种基于实现接口的实现代理类,跟目标类同级),
 * (如果该实现类没有接口,那么),其次选择cglib代理(这是一种基于继承当前实现类的代理,是目标类的子级)
 * @author HsiaotienPc
 *	这里有一个额外的扩充点, 如何改变默认的优先级规则, 或者说如何让一个基于目标类的接口,进行实现的代理类,改变代理方式, 使用cglib代理
 *
 *	补充一个知识点, 注解来确认切入点的两种方式, 在annotation包下 ,演练了其中的 一种,直接在通知注解上,明确poingcut
 *
 *此外还有一种pointcut的描述方式.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-extra.xml")
public class TestAspectExtra {
	
	private static final String UserServiceImpl = null;
	/*
	 *  这里先演示, 切入点明确的第二种方式
	 */
	@Autowired
	private IUserService userService;
	@Autowired
	private BookService bookService;
	
	@Test
	public void testPointCut() {
		
		userService.save();
		userService.find();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		bookService.save();
		bookService.find();
	}
	
	@Test
	public void testToggleProxyStyle() {
		
		userService.save();
		userService.find();
		((UserServiceImpl)userService).update();
		System.out.println("~~~~~~~~~~~~~~~~~~");
		bookService.save();
		bookService.find();
	}
	
}
