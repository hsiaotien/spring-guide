package com.dev.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transService")
public class TransServiceImpl implements ITransService {
	
	@Autowired
	private ITransDao transDao;
	
	@Transactional(readOnly=false)
	@Override
	public void trans(String outName, String inName, double money) {
		transDao.out(outName,money);
		//假设运行时异常,测试事务管理
//		int i = 1/0;
		transDao.in(inName,money);
	}

}
