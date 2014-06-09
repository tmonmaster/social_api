package kr.co.tmon.social.api.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml" })
public class AndroidAppDaoTest {

	@Autowired
	private AndroidAppDao androidAppDao;

	@Test
	public void testGetAndroidAppList() throws Exception {
		System.out.println(androidAppDao.getAndroidAppList());
	}
}
