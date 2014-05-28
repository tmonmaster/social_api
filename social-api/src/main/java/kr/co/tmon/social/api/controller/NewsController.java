package kr.co.tmon.social.api.controller;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import kr.co.tmon.social.api.service.NewsService;
import kr.co.tmon.social.api.vo.News;
import kr.co.tmon.social.api.vo.RootNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * News 객체를 JAXB로 Marshalling 한 결과 Stream을 String으로 반환하는 기능을 가진 클래스
 * 
 * @author 강이경
 * 
 */
@Controller
public class NewsController {

	private static JAXBContext CONTEXT;

	public NewsController() throws JAXBException {
		CONTEXT = JAXBContext.newInstance(RootNews.class);
	}

	@Autowired
	private NewsService newsService;

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping("/news")
	@ResponseBody
	/**
	 * Marshalling한 결과 XML 을 string으로 return 하는 메소드
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String printNewsListWithJaxb(String date) throws Exception {
		if (date == null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.format(new Date());
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		List<News> newsList = newsService.getNewsList(date);
		createNewsApiUsingJAXB(outputStream, newsList);

		return outputStream.toString();
	}

	/**
	 * 
	 * 뉴스 객체를 JAXB로 Marshalling하는 메소드
	 * 
	 * @param outputStream
	 * @param newsList
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	private void createNewsApiUsingJAXB(ByteArrayOutputStream outputStream, List<News> newsList) throws JAXBException, PropertyException {
		RootNews rootNews = new RootNews();
		rootNews.setNewsList(newsList);

		Marshaller marshaller = CONTEXT.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(rootNews, outputStream);
	}

}
