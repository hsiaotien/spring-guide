package com.dev.b_crud_two_way;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-crud.xml")
public class TestJdbcTemplate02 {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test() {
		User user = new User("xiaohei","123");
		userDao.insert(user);
		
		//userDao.delete("xiaohei");
		
		/*User user = new User("xiaohei", "666");
		userDao.update(user);*/
	}
	
	@Test
	public void testQuery() {
		User user = userDao.select("xiaohei");
		System.out.println(user);
	}
	@Test
	public void testQueryList() {
		List<User> list = userDao.selectList("xiao");
		for (User user : list) {
			System.out.println(user);
		}
	}
	


	
}
