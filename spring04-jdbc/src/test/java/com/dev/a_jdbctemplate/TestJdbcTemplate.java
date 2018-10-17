package com.dev.a_jdbctemplate;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestJdbcTemplate {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() throws SQLException {
		/**
		 * 使用JDBCTemplate编写程序（建表） ,基本步骤如下：
		1）构建连接池
		2）构建JDBCTemplate
		3）调用JDBCTemplate的execute方法
		 */
		//构建数据源对象
		/*DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///springdata");
		ds.setUsername("root");
		ds.setPassword("123");
		//构建JDBCTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);*/
		/*
		 * 优化第一步,数据源交给spring管理,
		 * (本质也是spring内置,但后续可以将其他的数据源交给spring)
		 */
		String sql = "create table user(username varchar(20),password varchar(20))";
		jdbcTemplate.execute(sql);
	}

	
	
	
}
