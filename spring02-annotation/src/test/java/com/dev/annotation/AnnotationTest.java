package com.dev.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
	/**
	 * 传统的xml完成依赖注入( 概念IOC DI)-->注解
	 */
	/**
	 * 扫描机制
	 * 
	 * @Component注解放置到类上 
	 * 相当于spring容器中定义：<bean id="customerService" class="cn.itcast.spring.a_ioc.CustomerService">
	 *其中id属性默认bean的名字是类名的小写
	 * 
	 * @Component(value="customerService")//自定义bean的名字 
	 * 相当于spring容器中定义：<bean id="customer" class="cn.itcast.spring.a_ioc.CustomerService">
	 */
	@Test
	public void testScan() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConsumerService consumerService = (ConsumerService) applicationContext
				.getBean("consumerService");
		consumerService.show();
		//手动关闭才能看到销毁方法
//		((ClassPathXmlApplicationContext) applicationContext).close();
	}

	/**
	 * 简单数据类型依赖注入
	 */
	@Test
	public void testValue() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConsumerService consumerService = (ConsumerService) applicationContext
				.getBean("consumerService");
		consumerService.showName();
	}

	/**
	 * 复杂类型数据依赖注入 ---在属性声明上面注入，底层自动还是生成setCustomerDao()
	 * 
	 * 第一种： 使用@Value 结合SpEL ---- spring3.0 后用
	 * 
	 * 第二种:a 单独使用@Autowired ，会到spring容器中查找CustomerDao的类型,表示按照类型注入 对应<bean
	 * class=””>
	 * 
	 * b 使用@Autowired + @ Qualifier 表示按照名称注入，回到spring容器中查找customerDao的名称，对应<bean
	 * id=””>
	 *
	 * @Autowired//默认按照类型注入的 
	 * @Qualifier("customerDao")//必须配合@Autowired注解使用，根据名字注入
	 * c. 此外@Autowired 可以放在方法上通过形参进行注入(构造函数上) 第三种
	 * a.单独使用@Resource注解，
	 *   表示先按照名称注入，会到spring容器中查找customerDao的名称，对应<bean id=””>，
	 *   id的属性值，如果找到，可以匹配。如果没有找到，则会按照类型注入，会到spring容器中查找CustomerDao的类型
	 *   对应<bean class=””>，class的属性值，如果找到，可以匹配，如果没有找到会抛出异常。
	 * b.如果@Resource注解上添加name名称使用@Resource注解，则按照名称注入，
	 *   会到spring容器中查找customerDao的名称 对应<bean id=””>，id的属性值，如果找到，可以匹配。 如果没有找到，抛出异常。
	 */
	@Test
	public void testComplexValue() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConsumerService consumerService = (ConsumerService) applicationContext
				.getBean("consumerService");
		consumerService.show();
	}

	/**
	 * Bean的初始化和销毁
	 * 
	 * 使用 @PostConstruct 注解， 标明初始化方法 ---相当于 init-method
	 * 指定初始化方法--当bean被载入到容器的时候调用setup ， 使用 @PreDestroy 注解， 标明销毁方法 ----相当于
	 * destroy-method 指定对象销毁方法 --当bean从容器中删除的时候调用teardown(scope= singleton有效)
	 */
	@Test
	public void testInitAndDestroyAnnotation() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");//默认是单例, 单例实体随着容器的创建而初始化
		LifeCycleBean lifeCycleBean = (LifeCycleBean) applicationContext.getBean("LifeCycle");
		lifeCycleBean.show();
		//销毁方法,有必要条件
		/*如果要执行对象的销毁方法 
		条件一： 单例Bean （在容器close时，单例Bean才会执行销毁方法 ）
		条件二： 必须调用容器 close 方法 */
		ClassPathXmlApplicationContext cpxAppContext = (ClassPathXmlApplicationContext)applicationContext;
		cpxAppContext.close();
	}
	
	/**
	 * Bean的作用域( 默认单例 )
	 *1. 可以看到只有作用域为单例, 它的构造方法(初始化方法) 随着 容器的创建而调用.(实例随着容器的创建而创建)
	 * 并且每次拿的都是同一个
	 *2. 作用域为多例,它实例的构造方法,即初始化方法,只有在在bean被创建的时候才执行
	 * 并且每次拿的不是同一个
	 */
	@Test
	public void testScope(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ScopeBean scopebean1 = (ScopeBean) applicationContext.getBean("scopeBean");
		ScopeBean scopebean2 = (ScopeBean) applicationContext.getBean("scopeBean");
		System.out.println(scopebean1);
		System.out.println(scopebean2);
	}
}
