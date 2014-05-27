package kr.co.tmon.social.api.dao;

import java.util.List;

import kr.co.tmon.social.api.vo.News;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author raspilla16@tmon.co.kr
 * 
 */
@Repository
public class NewsDao {

	private static final String NEWS_MAPPER = "kr.co.tmon.social.api.dao.mapper.NewsMapper.";

	@Autowired
	private SqlSession sqlSession;

	public List<News> getNewsList() {
		return sqlSession.selectList(NEWS_MAPPER + "getNewsList");
	}
}
