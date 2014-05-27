package kr.co.tmon.social.api.dao;

import kr.co.tmon.social.api.vo.News;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Yunho Lee
 * 
 *         NewsDao 테스트
 * 
 */
public class NewsDaoTest {

	@Test
	public void 디비에서뉴스목록가져오기() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml");
		NewsDao newsDao = (NewsDao) context.getBean("newsDao");

		for (News news : newsDao.getNewsList())
			System.out.println(news.toString());

	}
}
