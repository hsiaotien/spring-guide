package com.dev.trans;

public interface ITransDao {

	void out(String outName, double money);

	void in(String inName, double money);
}
