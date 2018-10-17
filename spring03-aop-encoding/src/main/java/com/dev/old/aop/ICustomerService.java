package com.dev.old.aop;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public interface ICustomerService {
	
	public void save();
	
	public void find();
}
