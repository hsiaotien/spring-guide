package com.dev.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 分析: 此方案,对三层结构有解耦作用. 但存在一个效率问题
		 * 每次访问此路径(此servlet),都不可避免的创建spring容器对象,而每次spring对象的创建本身需要消耗一定的资源
		 * 更严重的问题在于,spring容器的创建,会导致spring容器里的所有的bean的实例都会被初始化(准确的说是所有作用
		 * 域为单例的bean,都会被构造(即初始化对象)), 这些创建对象的方式非常消耗资源.
		 * 
		 * 解决方案: 将spring容器对象只创建一次,放入服务器的域对象中,而只有servletContext对象生命周期贯穿于整个服务器的开闭周期内
		 * ,所以方案,是将spring容器,存放在servletContext域对象中(也是一种容器),又此域对象管理
		 * 如何包装唯一? servletcontext监听器,可以在监听服务器开启事件,可以在服务器开启期间,一次创建,并保存,
		 * 即可包装spring对象的唯一,且只创建一次(在一个完整的服务器开启期间)
		 * 
		 * 方案的实施, 1.按思路设计实现spring的唯一创建
		 * 2. 实际上spring提供了解决方案,底层原理就是1的具体思路, spring框架对这些进行了封装,只需要配置框架的监听器即可.
		 */
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-web.xml");
		/**
		 * 原始解决方案,用到全局监听器包装spring容器的唯一.(待查看spring框架的封装底层原理,可以查看源码) ,
		 * 自己已经实现了一个全局监听器,将spring上下文对象初始化,并放入tomcat的全局上下文中
		 * 大致看了一下,基本原理是用服务器的全局域对象,具体实现没看明白
		 */
		/*ServletContext servletContext = this.getServletContext();
		ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
		HelloService helloService = (HelloService) applicationContext.getBean("helloService");*/
		
		/**
		 * 用spring框架封装的方法
		 * 只需要按照框架的约定配置监听器即可.
		 */
		ServletContext servletContext = this.getServletContext();
		ApplicationContext applicationContext =
				(ApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		HelloService helloService = (HelloService) applicationContext.getBean("helloService");
		System.out.println(helloService);
		System.out.println(applicationContext);
		helloService.sayHi();

		//实际上有提供了工具支持
		//工具类
//		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//TODO web在idea中并没有启动！ 原因无法配置tomcat.按钮失效
}
