package com.dev.springandweb;

import com.dev.web.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试用例不需要配置<context:annotion-config/>，因为使用测试类运行的时候，会自动启动注解的支持。
 * @author HsiaotienPc
 * 优势：可以简化测试代码（不需要手动创建上下文）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-web.xml")
public class springTest {
	
	@Autowired
	private HelloService helloService;
	
	@Test
	public void testSpringJunit(){
		/**
		 * 省去创建spring容器的代码
		 */
		helloService.sayHi();
	}
}
