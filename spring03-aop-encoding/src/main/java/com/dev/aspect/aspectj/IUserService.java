package com.dev.aspect.aspectj;
/**
 * 框架优先使用jdk动态代理,其次是cglib
 * @author HsiaotienPc
 *
 */
public interface IUserService {
	
	public void save();
	
	public void find();
}
