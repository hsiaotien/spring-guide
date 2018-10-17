package com.dev.trans;

public interface ITransService {
	
	//转账
	public void trans(String outName, String inName, double money);
}
