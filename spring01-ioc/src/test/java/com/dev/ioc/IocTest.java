package com.dev.ioc;

import com.dev.ioc.dao.IOrderDao;
import com.dev.ioc.inject.Car;
import com.dev.ioc.inject.Person;
import com.dev.ioc.scope.ProtoTypeBean;
import com.dev.ioc.service.IOrderService;
import com.dev.ioc.service.impl.OrderServiceImpl;
import com.dev.old.dao.IUserDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class IocTest {

	/**
	 * IOC实现
	 */
	@Test
	public void testIoc() {
		// 获取spring容器
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 工厂获取对象
		IUserDao userDao = (IUserDao) applicationContext.getBean("UserDao");
		// 执行
		userDao.findUserByUsernameAndPassword();
		// 发现问题:该方式虽然解决了类与类之间的耦合关系,
		// 但却需要在获取对象的时候创建spring工厂,有没有更方便获取对象的依赖的方法呢?
	}

	/**
	 * DI 依赖的注入
	 */
	@Test
	public void testIOCForDI() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IOrderService orderService = (IOrderService) applicationContext
				.getBean("OrderService");
		orderService.queryOrder();
	}

	/**
	 * 测试applicationContext的非延迟加载
	 */
	@Test
	public void testNotDelay() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		/*
		 * 可以看到applicationContext是非延迟加载的, 该上下文对象(工厂)被new,就初始化了它的配置对象.属于非延迟加载
		 */
	}

	/**
	 * 测试顶层接口beanFactory的延迟加载 ( applicationContext的顶层接口) , 待测试...
	 */
	@Test
	public void testDelay() {
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("E:/github-hsiaotien/spring-guide/spring01-ioc/src/main/resources/applicationContext.xml"));
		// 可以看到工厂顶级接口是延迟加载的, 不调用工厂的获取实例的方法获取实例, 工厂中的实例是不会被实例化的.
		// 只有获取这些实例才会初始化这些实例,实例调方法在后同理,也会初始化实例
		IOrderService orderService = (IOrderService) bf.getBean("OrderService");
		System.out.println("jieshu");

	}

	/**
	 * bean实例获取的两种方式
	 */
	@Test
	public void testWayOfGetBean() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IOrderService orderService = (IOrderService) applicationContext
				.getBean(OrderServiceImpl.class);
		orderService.queryOrder();
		/*
		 * bean实例获取的方式有两种,一种是通过配置文件,一种通过class字节码文件对象. 
		 * 常用根据名称获取（id/name）,即第一种方式
		 * 第二种存在风险: 如果根据类型获取，配置了多个类型的话，则抛出异常：
		 */
	}

	/**
	 * bean实例实例化的三种方式 第一种:常用的无参构造方式( 反射空参构造方法 注意有参构造会替换默认的空参构造,需要补充空参构造) 第二种:
	 * 静态工厂的方式 第三种: 实例工厂的方式 第一种：最常用 第二、第三种：一些框架初始化的时候用的多。 在工厂获取对象的方法中,可以对该对象 ,如
	 * orderdaoimpl 可以对在获取bean对象之前做一些初始化工作
	 */
	@Test
	public void testInstanceWay() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 静态工厂
		// IOrderDao orderdaoimpl = (IOrderDao)
		// applicationContext.getBean("orderdaoimpl");
		// 实例工厂
		IOrderDao orderdaoimpl = (IOrderDao) applicationContext
				.getBean("orderdaoimplother");
		orderdaoimpl.queryOrder();
	}

	/**
	 * Bean的作用域
	 * 演示常见的两个单例singleton 和 多例 prototype
	 */
	@Test
	public void testScope() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//scope = single
		//单例：每次从spring容器中获取的对象，是同一个对象
		//单例初始化：是在spring容器初始化的时候，就初始化了

		IOrderDao orderDao1 = (IOrderDao) applicationContext.getBean("singletonBean");
		IOrderDao orderDao2 = (IOrderDao) applicationContext.getBean("singletonBean");
		System.out.println(orderDao1);
		System.out.println(orderDao2);
		//scope = prototype
		//获取多例的bean：
		//多例：每次从spring容器中获取的对象，不是同一个对象
		//多例初始化：是在getBean的时候初始化，相当于每次getbean就是在new Bean（）

		IOrderDao orderDao4 = (IOrderDao) applicationContext.getBean("prototypeBean");
		IOrderDao orderDao5 = (IOrderDao) applicationContext.getBean("prototypeBean");
		System.out.println(orderDao4);
		System.out.println(orderDao5);
		
		//此外注意静态bean的初始化时机
	}
	
	/**
	 * Bean的生命周期  设置初始化后的init方法,和destroy销毁前的方法.
	 */
	@Test
	public void testInitDestroy(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOrderDao lifecycle = (IOrderDao) applicationContext.getBean("lifecycle");
		applicationContext.close();
	}
	
	 /**
	  * scope, 对象初始化和实例化时机 
	  */
	
	@Test
	public void testScopeLast(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProtoTypeBean proto = (ProtoTypeBean) applicationContext.getBean("proto");
		/**
		 * 可以看到单例和多例的实例初始化时机是不一致的
		 * 单例bean是随着容器的创建而初始化
		 * 多例bean是随着bean被创建的时候而初始化
		 */
		
	}
	
	/**
	 * 属性的依赖注入.构造器参数标签
	 */
	@Test
	public void testInject(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car);
	}
	/**
	 * 属性的setter注入
	 */
	@Test
	public void testInjectplus(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
	}
	
	/**
	 * p 空间
	 */
	@Test
	public void testInject_p(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("p-person");
		System.out.println(person);
	}
	
	/**
	 * spEL表达式的使用 
	 */
	@Test
	public void testInject_spEL(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("spEL-person");
		System.out.println(person);
	}
	
	
}
