package kr.co.tmon.social.api.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.social.api.service.NewsService;
import kr.co.tmon.social.api.vo.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * NewsController.printNewsLi트stWithJaxb 동작 테스트
 * 
 * @author u_kino07
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsControllerTest {

	@Mock
	private NewsService newsService;

	@InjectMocks
	private NewsController newsController;

	@Test
	public void printNewsListWithJaxb() throws Exception {
		List<News> newsList = new ArrayList<>();

		newsList.add(new News("티켓몬스터", "PC 눈 보호안경 &quot;아이프로텍션 PC&quot; 기가바이트와 제휴 통해 할인 쿠폰 이벤트 진행", "현재 라식전문병원과 프로게임단의 프로게이머가 눈 보호용으로 채택하여 사용 중에 있는 제품이다. 본 제품은 현재 이마트, 전자랜드, 지마켓, 쿠팡, 티몬, 농심 메가마트(판도라) 등에서 만나 볼 수 있다.", "url=\"http://imgnews.naver.net/image/thumb140/5270/2014/05/19/23537.jpg\"", "Mon, 19 May 2014 17:27:00 +0900",
				"http://www.acrofan.com/ko-kr/consumer/news/20140519/00000095", "아크로팬"));

		when(newsService.getNewsList("2014-05-27")).thenReturn(newsList);

		String xmlString = newsController.printNewsListWithJaxb("2014-05-27");
		System.out.println(xmlString);
	}
}
