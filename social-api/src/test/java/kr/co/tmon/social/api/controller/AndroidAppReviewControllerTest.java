package kr.co.tmon.social.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.service.AndroidAppService;
import kr.co.tmon.social.api.vo.AndroidApp;
import kr.co.tmon.social.api.vo.AndroidAppReview;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * AndroidAppReviewController 테스트 클래스
 * 
 * @author 강이경
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class AndroidAppReviewControllerTest {
	@Mock
	private AndroidAppReviewService androidAppReviewService;

	@Mock
	private AndroidAppService androidAppService;

	@InjectMocks
	private AndroidAppReviewController androidAppReviewController;

	@Before
	public void androidAppReviewList_세팅() throws ParseException {
		List<AndroidAppReview> dummyAndroidAppReviewList = new ArrayList<AndroidAppReview>();
		dummyAndroidAppReviewList.add(new AndroidAppReview("reviewLink", "userName", "userLink", "reviewDate", "starScore", "reviewTitle", "reviewContent", "companyName", "androidAppName", "androidAppVersion"));

		when(androidAppReviewService.selectAndroidAppReviewListBetween("2014-05-28", "2014-05-30")).thenReturn(null);
		when(androidAppReviewService.selectAndroidAppReviewListBetween("2014-06-01", "2014-06-03")).thenReturn(dummyAndroidAppReviewList);

		List<AndroidApp> androidAppList = new ArrayList<AndroidApp>();
		AndroidApp androidApp = new AndroidApp();
		androidApp.setAppName("티몬");
		androidApp.setAverageScore("4.1");
		androidAppList.add(androidApp);

		when(androidAppService.getAndroidAppList()).thenReturn(androidAppList);
	}

	@Test
	public void List가_null일때와_List에_내용이_있을때_각각_JSON스트링이_올바르게_출력되는지_확인() throws Exception {
		System.out.println(androidAppReviewController.getAndroidAppReviewList("2011-05-28", "2011-05-30", null).getBody());
		assertEquals(androidAppReviewController.getAndroidAppReviewList("2011-05-28", "2011-05-30", null).getBody(), "{\"scoreList\":[{\"appName\":\"티몬\",\"averageScore\":\"4.1\"}],\"reviewList\":[]}");
	}
}
