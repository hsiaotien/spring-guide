package com.dev.aspect.extra;

import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public void save() {
		System.out.println("UserServiceImpl保存");
//		double i = 1/0;//测试异常通知
	}

	@Override
	public double find() {
		System.out.println("UserServiceImpl查询");
		return 5.20;
	}
	
	/**
	 * 添加一个非接口中方法, 这个方法是无法是用jdk 代理模式来进行增强的, 必须转变默认的增强优先级
	 * 设置 proxy-target-class = true 
		方案一：注解方式：
		<!-- 配置aop的aspectj的自动代理：
			自动扫描bean组件中，含有@Aspect的bean，将其作为aop管理，开启动态代理
				proxy-target-class:设置是否使用cglib代理，默认是false，表示使用的是jdk接口代理
				proxy-target-class="true"：表示cglib代理
		-->
		<aop:aspectj-autoproxy proxy-target-class="true"/>
		方案二：配置文件XML的方式
		<!-- 3：配置aop -->
    	<aop:config proxy-target-class="true">
   		</aop:config>

	 */
	
	public void update() {
		System.out.println("更新方法不是接口的方法,而是实现类的特有方法,那么 也就无法用jdk代理增强了");
	}
}

