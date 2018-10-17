package com.dev.trans;
/*
 * 【注意】：数据源的注解注入 需要自己添加set方法
 */

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("transDao")
public class TransDaoImpl extends JdbcDaoSupport implements ITransDao {
	
	@Autowired///当初始化dao的时候，会调用该方法啊，通过set方法的形参注入数据源
	public void abc(DataSource dataSource) {//方法名无所谓, 只要不和父类同名即可,因为父类该方法为final.不能重写, 
		//只能继承.拿就要考虑重载了
		super.setDataSource(dataSource);//此类中不能有这个方法,因为相当于复写了不可复写的方法.
		//这一步核心, 根据形参注入, 注意和xml配置的区别, 看似没有datasource 属性和setter方法, 但它有继承setter方法
		//归根结底就是通过set方法的形参注入
	}

	@Override
	public void out(String outName, double money) {
		String sql = "update t_account set money=money-? where name = ?";
		super.getJdbcTemplate().update(sql, money,outName);
	}

	@Override
	public void in(String inName, double money) {
		String sql = "update t_account set money=money+? where name = ?";
		super.getJdbcTemplate().update(sql, money,inName);
	}

}
