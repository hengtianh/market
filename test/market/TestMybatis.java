package market;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hengtian.dao.UserDao;
import com.hengtian.mapper.UserMapper;
import com.hengtian.po.User;

public class TestMybatis {

	private ApplicationContext context;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testFactory(){
		SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		System.out.println(factory);
	}
	
	@Test
	public void testFindUser(){
		UserDao uDao = (UserDao) context.getBean("userDao");
		User u = new User();
		u.setEmail("123@qq.com");
		u.setPwd("123");
		User user = uDao.findUserToLogin(u);
		System.out.println(user.getRealName());
		
	}
	
	@Test
	public void testFindUserProxy() throws Exception{
		UserMapper uMapper = (UserMapper) context.getBean("userMapper");
		User u = new User();
		u.setEmail("123@qq.com");
		u.setPwd("123");
		User user = uMapper.findUserToLogin(u);
		System.out.println(user.getRealName());
		
	}
	
	@Test
	public void testInsertUserProxy() throws Exception{
		UserMapper uMapper = (UserMapper) context.getBean("userMapper");
		User u = new User();
		u.setEmail("124@qq.com");
		u.setGender("Å®");
		u.setPhone("123");
		u.setAddress("10#119");
		u.setPwd("123");
		u.setRealName("ÅË½ðÁ«");
		uMapper.insertUser(u);
	}
}
