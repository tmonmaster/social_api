package kr.co.tmon.social.api.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import kr.co.tmon.social.api.dao.NewsDao;
import kr.co.tmon.social.api.vo.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raspilla16@tmon.co.kr
 * 
 */
@Service
public class NewsService {

	@Autowired
	private NewsDao newsDao;

	/**
	 * @param outputStream
	 */
	public void printJaxbNewsList(ServletOutputStream outputStream) {
		// TODO Auto-generated method stub
	}
}
