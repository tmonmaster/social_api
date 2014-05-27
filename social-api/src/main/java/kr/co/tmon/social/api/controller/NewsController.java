package kr.co.tmon.social.api.controller;

import javax.servlet.http.HttpServletResponse;

import kr.co.tmon.social.api.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author raspilla16@tmon.co.kr
 * 
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping("/news.xml")
	public void printNewsListWithJaxb(HttpServletResponse response) throws Exception {
		newsService.printJaxbNewsList(response.getOutputStream());
	}
}
