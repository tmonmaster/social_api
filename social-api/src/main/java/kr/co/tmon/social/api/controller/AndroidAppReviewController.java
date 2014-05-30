package kr.co.tmon.social.api.controller;

import java.util.List;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.vo.AndroidAppReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

/**
 * AndroidAppReview 객체를 JSON으로 변환한 결과 Stream을 String으로 반환하는 클래스
 * 
 * @author 강이경
 * 
 */
@Controller
public class AndroidAppReviewController {
	@Autowired
	private AndroidAppReviewService androidAppReviewService;

	public void setAndroidAppReviewService(AndroidAppReviewService androidAppReviewService) {
		this.androidAppReviewService = androidAppReviewService;
	}

	public String getAndroidAppReviewListUsingJSON(List<AndroidAppReview> androidAppReviewList) {
		if (androidAppReviewList == null)
			return null;
		Gson gson = new Gson();
		return gson.toJson(androidAppReviewList);
	}
}
