package kr.co.tmon.social.api.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.vo.AndroidAppReview;

/**
 * AppReviewContoller.getAppReviewListUsingJSON 테스트
 * 
 * @author 강이경
 * 
 */
public class AndroidAppReviewControllerTest {
	@Test
	public void getAndroidAppReviewListUsingJSON() {
		AndroidAppReviewController androidAppReviewController = new AndroidAppReviewController();
		AndroidAppReviewService androidAppReviewService = mock(AndroidAppReviewService.class);
		androidAppReviewController.setAndroidAppReviewService(androidAppReviewService);

		List<AndroidAppReview> androidAppReviewList = new ArrayList<AndroidAppReview>();
		androidAppReviewList.add(new AndroidAppReview(
				"https://play.google.com/store/apps/details?id=com.tmon&reviewId=Z3A6QU9xcFRPR2tpTTJQQUlDZXRUM21hOHg0VHRCNkIyTVVwMW5QT1E3VWRXRGRpSEM1VzBYMTJlaU9Bc01fRHR6U2dKRzNoZXUyNnNkS0pRN3FVVE5FTHc", 
				"정혜경", 
				"https://play.google.com/store/people/details?id=111359932959764103963", 
				"2014년 5월 28일", 
				"20%", 
				"안하고말지요",
				"무슨문제인지는 모르겟지만 검색후에 아래로 내리면 다시 티몬 로그인 동그라미 화면나오고 이래서 머 하겠어요 다신안함", 
				"티켓몬스터",
				"tmonplus",
				"3.3.1"));

		when(androidAppReviewService.getAndroidAppReviewList()).thenReturn(androidAppReviewList);

		String jsonString = androidAppReviewController.getAndroidAppReviewListUsingJSON(androidAppReviewList);
		System.out.println(jsonString);
	}
}
