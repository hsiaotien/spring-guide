package com.dev.old;

import com.dev.old.service.impl.UserServiceImpl4;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void test(){
		//1.最原始的三层机构--高度耦合,直接使用了类名,并且层与层之间有耦合
		//new UserServiceImpl().findUserByUsernameAndPassword();
		
		//2.组合关系--解决层与层之间的耦合,但并未解决类名的耦合
		/*IUserDao userDaoImpl = new UserDaoImpl();
		UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();
		userServiceImpl2.setUserDao(userDaoImpl);
		userServiceImpl2.findUserByUsernameAndPassword();*/
		
		//3.组合关系加反射--解决了层与层的耦合,也解决了类名的耦合, 但引入硬编码也是一种耦合
		//new UserServiceImpl3().findUserByUsernameAndPassword();
		
		//4.我的工厂模式,一定程度上可以解决层与层的关系
		//工厂模式的升级版,加组合加反射后的工厂模式--接近框架的设计IOC思想
		new UserServiceImpl4().findUserByUsernameAndPassword();
		
		//上述四步,已经完成了一个框架的基本演变过程. 如果通过配置文件进行配置.就属于一种框架解决方案
		//解决方案: 使用xml配置文件动态传入类字符串
		//IoC底层实现：工厂（设计模式）+反射（机制） + 配置文件（xml）。
	}
}

