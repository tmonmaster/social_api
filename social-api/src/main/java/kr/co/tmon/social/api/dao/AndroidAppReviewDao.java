package kr.co.tmon.social.api.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.tmon.social.api.vo.AndroidAppReview;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DB에서 AndroidAppReviewList를 가져오는 DAO 클래스
 * 
 * @author 강이경
 * 
 */
@Repository
public class AndroidAppReviewDao {
	private static final String ANDROID_APP_REVIEW_MAPPER = "kr.co.tmon.social.api.dao.mapper.AndroidAppReviewMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	public List<AndroidAppReview> selectAndroidAppReviewListBetween(String startDate, String endDate) throws ParseException {
		
		if(StringUtils.isEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(endDate));
			calendar.add(Calendar.DATE, -7);
			startDate = dateFormat.format(calendar.getTime());
		}
		
		if(StringUtils.isNotEmpty(startDate) && StringUtils.isEmpty(endDate)){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();			
			calendar.setTime(dateFormat.parse(startDate));
			calendar.add(Calendar.DATE, 7);
			endDate = dateFormat.format(calendar.getTime());
		}
		
		if(StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			startDate = dateFormat.format(calendar.getTime());
			calendar.add(Calendar.DATE, 7);
			endDate = dateFormat.format(calendar.getTime());
		}
		
		if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
	
		return sqlSession.selectList(ANDROID_APP_REVIEW_MAPPER + "getAndroidAppReviewList", map);
	}
}
