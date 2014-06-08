package kr.co.tmon.social.api.service;

import java.text.ParseException;
import java.util.List;

import kr.co.tmon.social.api.dao.AndroidAppReviewDao;
import kr.co.tmon.social.api.vo.AndroidAppReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DAO 에서 AndroidAppReviewList를 가져와 Controller에 전달하는 클래스
 * 
 * @author 강이경
 * 
 */
@Service
public class AndroidAppReviewService {
	@Autowired
	private AndroidAppReviewDao androidAppReviewDao;

	public List<AndroidAppReview> selectAndroidAppReviewListBetween(String startDate, String endDate) throws ParseException {
		return androidAppReviewDao.selectAndroidAppReviewListBetween(startDate, endDate);
	}
}
