package kr.co.tmon.social.api.controller;

import java.text.ParseException;
import java.util.List;

import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.vo.AndroidAppReview;
import kr.co.tmon.social.api.vo.RootAndroidAppReview;

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
	 * @throws ParseException 
	 */
	@RequestMapping("/appReview")
	@ResponseBody
	public String getJsonStringOfAndroidAppReviewListBetween(String startDate, String endDate) throws ParseException {
		List<AndroidAppReview> androidAppReviewList = androidAppReviewService.selectAndroidAppReviewListBetween(startDate, endDate);
		if (androidAppReviewList == null)
			return "{\"reviewCount\":0,\"androidAppReviewList\": List is empty. }";

		return createJsonStringBy(androidAppReviewList);
	}

	/**
	 * androidAppReviewList를 받아서 Wrapper 클래스로 싼 뒤, Json으로 변환하는 메소드
	 * 
	 * @param androidAppReviewList
	 * @return String
	 * @author 강이경
	 */
	private String createJsonStringBy(List<AndroidAppReview> androidAppReviewList) {
		Gson gson = new Gson();
		RootAndroidAppReview meta = new RootAndroidAppReview(androidAppReviewList);
		return gson.toJson(meta);
	}
}
