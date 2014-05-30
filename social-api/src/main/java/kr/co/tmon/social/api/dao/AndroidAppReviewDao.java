package kr.co.tmon.social.api.dao;

import java.util.List;

import kr.co.tmon.social.api.vo.AndroidAppReview;

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
	private static final String ANDROID_APP_REVIEW_MAPPER = "kr.co.tmon.social.api.dao.mapper.AndroidAppMapper.";
	@Autowired
	private SqlSession sqlSession;

	public List<AndroidAppReview> getAndroidAppReviewList() {
		return sqlSession.selectList(ANDROID_APP_REVIEW_MAPPER + "getAndroidAppReviewList");
	}
}
