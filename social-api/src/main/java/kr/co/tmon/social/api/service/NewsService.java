package kr.co.tmon.social.api.service;

import java.util.List;

import kr.co.tmon.social.api.dao.NewsDao;
import kr.co.tmon.social.api.vo.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 강이경
 * 
 * DAO 에서 NewsList를 가져와 Controller에 전달하는 클래스
 */
@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
}
