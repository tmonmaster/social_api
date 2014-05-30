package kr.co.tmon.social.api.dao;

import kr.co.tmon.social.api.vo.AndroidAppReview;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * AndroidAppReviewDao 테스트 클래스
 * 
 * @author 강이경
 *
 */
public class AndroidAppReviewDaoTest {
	@Test
	public void _AndroidAppReviewDao_테스트() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml");
		AndroidAppReviewDao androidAppReviewDao = (AndroidAppReviewDao) context.getBean("androidAppReviewDao");

		for (AndroidAppReview androidAppReview : androidAppReviewDao.getAndroidAppReviewList())
			System.out.println(androidAppReview.toString());
	}
}
