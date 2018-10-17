package com.dev.b_crud_two_way;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport {

	/*
	 * private JdbcTemplate jdbcTemplate;
	 * 
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { 
	 * 		this.jdbcTemplate =jdbcTemplate; } 
	 * 
	 * public void insert(User user){
	 * 
	 * 		String sql = "insert into user(username,password)values(?,?)";
	 *	 jdbcTemplate.update(sql,user.getUsername(),user.getPassword()); 
	 * }
	 * jdbcTemplate继承的一个抽象适配器类,有私有的datasource属性,和可以被继承的setdatasource方法, 
	 * 显然,jdbctemplate对象是需要注入datasource的, 这里是通过datasource注入
	 */

	/*
	 * 还有一种方式,继承Spring框架封装的JdbcDaoSupport类获得jdbctemplate对象操作数据库
	 * 
	 * 从源码角度看, 父类中有jdbctemplate对象作为成员属性, 并且为私有属性, 子类虽然不能继承, 但可以调用父类的一些获取此成员的方法来完成工作,
	 * 此外,父类的此成员依赖数据源,需要传入数据源
	 * 
	 * 这个父类有setjdbctemplate方法,并能不子类继承,即被这里的UserDao继承,那么就可以了, 
	 * 而这个jdbctemplate对象也需要该类的setdatasource方法,即 jdbcdaosuport也需要数据源. 同第一种方法一样
	 * ,只需要给子类注入datasource即可, 给userdao注入即可, userdao可以调用jdbcdaosuport的setdatasource方法和
	 * setjdbctemplate方法, 实例jdbctemplete, 并通过调用父类的getjdbctemplate方法获取 jdbctemplete模板对象
	 * 
	 * 非常经典的继承设计,父类提供了setdatasource 和setjdbctemplate方法以及get模板的方法, 
	 * 让子类可以继承,子类就可以注入所需要的数据源,来获取jdbc模板对象了.
	 * 
	 *  子类帮父类实例化父类的成员对象属性,然后子类又可以拿.,只需要子类继承该父类,并注入数据源即可
	 * 
	 * 注意,父类的很多关于此成员的方法被final修饰,都不能被重写,但可以继承.
	 */
	
	public void insert(User user) {

		String sql = "insert into user(username,password)values(?,?)";
		super.getJdbcTemplate().update(sql, user.getUsername(), user.getPassword());
		//this. 或者 super. 调父类的方法都可以,但super调用,效率更高
	}
	
	//增删改..类似方法
	public void delete(String username) {
		
		String sql = "delete from user where username=?";
		super.getJdbcTemplate().update(sql, username);
	}
	
	public void update(User user) {
		String sql ="update user set password=? where username=?";
		super.getJdbcTemplate().update(sql, user.getPassword(),user.getUsername());
	}
	
	/*
	 * 查询的参数稍微复杂点, 查询分查询单个, 和查询多个(即返回一个集合)
	 */
	
	public User select(String username) {
		String sql = "select * from user where username=?";
		User user = super.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
		return user;
	}
	
	public List<User> selectList(String keyword) {
		String sql = "select * from user where username like ?";
		List<User> list = super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class), "%"+keyword+"%");
		return list;
	}
}
