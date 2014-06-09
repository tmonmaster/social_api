package kr.co.tmon.social.api.controller;

import java.text.ParseException;
import java.util.List;

import kr.co.tmon.social.api.controller.util.ResponseEntityUtil;
import kr.co.tmon.social.api.service.AndroidAppReviewService;
import kr.co.tmon.social.api.service.AndroidAppService;
import kr.co.tmon.social.api.vo.AndroidApp;
import kr.co.tmon.social.api.vo.AndroidAppReview;
import kr.co.tmon.social.api.vo.RootAndroidAppReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Autowired
	private AndroidAppService androidAppService;

	/**
	 * "/appReview" 로 요청이 들어오면 androidAppReviewList를 Json으로 변환한 결과값을 반환하는 메소드
	 * 
	 * @return String
	 * @author 강이경
	 * @throws ParseException
	 * @throws Exception
	 */
	@RequestMapping("/appReview")
	@ResponseBody
	public ResponseEntity<String> getAndroidAppReviewList(String startDate, String endDate, String type) throws Exception {
		List<AndroidAppReview> androidAppReviewList = androidAppReviewService.selectAndroidAppReviewListBetween(startDate, endDate);
		List<AndroidApp> androidAppList = androidAppService.getAndroidAppList();

		RootAndroidAppReview androidAppReviewWithMeta = new RootAndroidAppReview();
		androidAppReviewWithMeta.setReviewList(androidAppReviewList);
		androidAppReviewWithMeta.setAverageScoreList(androidAppList);

		if (type != null && type.equalsIgnoreCase("xml"))
			return ResponseEntityUtil.getXmlResponseEntity(androidAppReviewWithMeta);

		return ResponseEntityUtil.getJsonResponseEntity(androidAppReviewWithMeta);
	}
}
