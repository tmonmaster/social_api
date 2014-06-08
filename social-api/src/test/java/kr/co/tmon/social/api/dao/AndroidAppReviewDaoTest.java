package kr.co.tmon.social.api.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.List;

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
	public void AndroidAppReviewDao_테스트() throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml", "classpath:spring/dispatcher-servlet.xml");
		AndroidAppReviewDao androidAppReviewDao = (AndroidAppReviewDao) context.getBean("androidAppReviewDao");

		List<AndroidAppReview> androidAppReviewList = androidAppReviewDao.selectAndroidAppReviewListBetween("2014-05-26", "2014-05-28");
		assertNotNull(androidAppReviewList);

		for (AndroidAppReview androidAppReview : androidAppReviewList) {
			String reviewDate = androidAppReview.getReviewDate();
			assertTrue(reviewDate.equals("2014-05-26") || reviewDate.equals("2014-05-27") || reviewDate.equals("2014-05-28"));
		}
	}
}
