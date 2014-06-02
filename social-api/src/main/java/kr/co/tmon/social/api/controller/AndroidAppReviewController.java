package kr.co.tmon.social.api.controller;

import java.util.List;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.vo.AndroidAppReview;
import kr.co.tmon.social.api.vo.AndroidAppReviewWrapperForMeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * "/appReview" 로 요청이 들어오면 androidAppReviewList를 Json으로 변환한 결과값을 반환하는 메소드
	 * 
	 * @return String
	 * @author 강이경
	 */
	@RequestMapping("/appReview")
	@ResponseBody
	public String getJsonForAndroidAppReviewList() {
		List<AndroidAppReview> androidAppReviewList = androidAppReviewService
				.getAndroidAppReviewList();
		if (androidAppReviewList == null)
			return null;

		return convertToJson(androidAppReviewList);
	}

	/**
	 * androidAppReviewList를 받아서 Wrapper 클래스로 싼 뒤, Json으로 변환하는 메소드
	 * 
	 * @param androidAppReviewList
	 * @return String
	 * @author 강이경
	 */
	private String convertToJson(List<AndroidAppReview> androidAppReviewList) {
		Gson gson = new Gson();
		AndroidAppReviewWrapperForMeta meta = new AndroidAppReviewWrapperForMeta(
				androidAppReviewList);
		return gson.toJson(meta);
	}
}
