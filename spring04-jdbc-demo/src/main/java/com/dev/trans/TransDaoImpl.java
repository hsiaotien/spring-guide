package com.dev.trans;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TransDaoImpl extends JdbcDaoSupport implements ITransDao {

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
