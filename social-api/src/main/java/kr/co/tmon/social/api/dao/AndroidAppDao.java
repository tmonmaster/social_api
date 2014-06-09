package kr.co.tmon.social.api.dao;

import java.util.List;

import kr.co.tmon.social.api.vo.AndroidApp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 정승현 - RASPILLA16@tmon.co.kr
 * 
 */
@Repository
public class AndroidAppDao {

	private static final String ANDROID_APP_MAPPER = "kr.co.tmon.social.api.dao.mapper.AndroidAppMapper.";
	@Autowired
	private SqlSession sqlSession;

	public List<AndroidApp> getAndroidAppList() {
		return sqlSession.selectList(ANDROID_APP_MAPPER + "getAndroidAppList");
	}
}
