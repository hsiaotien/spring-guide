package com.dev.weblistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SingleAppContext
 *
 */
public class SingleAppContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SingleAppContext() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//在一个服务器开闭的周期内,applicationContext只会创建一次, 即spring容器只会创建一次,那么容器内的说所有单例bean,
    	//就不会每次访问都被构造初始化
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-web.xml");
    	ServletContext servletContext = sce.getServletContext();
    	//将spring 容器放入 服务器全局域对象servletContext中,独此一份
    	servletContext.setAttribute("applicationContext", applicationContext);
        System.out.println("servletContext域对象创建了");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("servletContext域对象销毁了");
    }
	
}
