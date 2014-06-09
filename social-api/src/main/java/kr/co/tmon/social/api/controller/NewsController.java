package kr.co.tmon.social.api.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.tmon.social.api.controller.util.ResponseEntityUtil;
import kr.co.tmon.social.api.service.NewsService;
import kr.co.tmon.social.api.vo.News;
import kr.co.tmon.social.api.vo.RootNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * News 객체를 JAXB로 Marshalling 한 결과 Stream을 String으로 반환하는 기능을 가진 클래스
 * 
 * @author 강이경
 * 
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	/**
	 * Marshalling한 결과 XML 을 string으로 return 하는 메소드
	 * 
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/news")
	public ResponseEntity<String> printNewsList(String date) throws Exception {
		if (date == null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.format(new Date());
		}

		List<News> newsList = newsService.getNewsList(date);

		RootNews rootNews = new RootNews();
		rootNews.setNewsList(newsList);

		return ResponseEntityUtil.getXmlResponseEntity(rootNews);
	}
}
