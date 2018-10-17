package com.dev.trans;

public class TransServiceImpl implements ITransService {
	
	private ITransDao transDao;
	
	public void setTransDao(ITransDao transDao) {
		this.transDao = transDao;
	}

	@Override
	public void trans(String outName, String inName, double money) {
		transDao.out(outName,money);
		//假设运行时异常,测试事务管理
		int i = 1/0;
		transDao.in(inName,money);
	}

}
