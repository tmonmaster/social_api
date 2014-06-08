package kr.co.tmon.social.api.controller;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.vo.AndroidAppReview;
import kr.co.tmon.social.api.vo.RootAndroidAppReview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;

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

	@InjectMocks
	private AndroidAppReviewController androidAppReviewController;

	@Before
	public void androidAppReviewList_세팅() throws ParseException {
		List<AndroidAppReview> dummyAndroidAppReviewList = new ArrayList<AndroidAppReview>();
		dummyAndroidAppReviewList.add(new AndroidAppReview("reviewLink", "userName", "userLink", "reviewDate", "starScore", "reviewTitle", "reviewContent", "companyName", "androidAppName", "androidAppVersion"));

		when(androidAppReviewService.selectAndroidAppReviewListBetween("2014-05-28", "2014-05-30")).thenReturn(null);
		when(androidAppReviewService.selectAndroidAppReviewListBetween("2014-06-01", "2014-06-03")).thenReturn(dummyAndroidAppReviewList);
	}

	@Test
	public void List가_null일때와_List에_내용이_있을때_각각_JSON스트링이_올바르게_출력되는지_확인() throws ParseException {
		assertEquals(androidAppReviewController.getJsonStringOfAndroidAppReviewListBetween("2014-05-28", "2014-05-30"), "{\"reviewCount\":0,\"androidAppReviewList\": List is empty. }");

		String expectedJsonString = "{\"reviewCount\":1,\"androidAppReviewList\":[{\"reviewLink\":\"reviewLink\",\"userName\":\"userName\",\"userLink\":\"userLink\",\"reviewDate\":\"reviewDate\",\"starScore\":\"starScore\",\"reviewTitle\":\"reviewTitle\",\"reviewContent\":\"reviewContent\",\"companyName\":\"companyName\",\"androidAppName\":\"androidAppName\",\"androidAppVersion\":\"androidAppVersion\"}]}";
		assertEquals(androidAppReviewController.getJsonStringOfAndroidAppReviewListBetween("2014-06-01", "2014-06-03"), expectedJsonString);
	}
}
