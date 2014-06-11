package kr.co.tmon.social.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.social.api.dao.NewsDao;
import kr.co.tmon.social.api.vo.News;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * 
 * @author Yunho Lee (forfle@tmon.co.kr)
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsServiceTest {
	private static final int FIRST_INDEX = 0;

	private static final String PREVIEW_SEPARATOR = "(PREVIEW_SEPARATOR)";

	@Mock
	private NewsDao newsDao;

	@InjectMocks
	private NewsService newsService;

	@Test
	public void newsServiceTest() throws Exception {
		List<News> allNewsList = new ArrayList<>();
		News news = new News();
		news.setSocialName("티켓몬스터,쿠팡,위메프");
		news.setTitle("소셜커머스, '고객 중심 경영'으로 새시대 연다");
		news.setPreview("신현성 티몬 대표는 &quot;100조원의 가치가 있는 국내 e-커머스 시장에서 많은... 지난해 하반기 치열한 경쟁을 펼쳤던 티몬과 위메프는 각각 707억원... ◆티몬 &quot;고객이 가장 먼저 찾는 기업 될 것&quot; 티몬은 가격과 상품, 서비스를...(PREVIEW_SEPARATOR) 업계에서는 쿠팡 역시 실적 공개 대상은 아니지만 적자를 면치 못했을... ◆쿠팡 &quot;고객 중심 경영, 우리가 먼저!” 쿠팡은 초창기부터 '고객 만족'을... 쿠팡은 고객 서비스 만족도 향상을 위해 지난 2011년 상반기 고객센터를...(PREVIEW_SEPARATOR) 지난해 하반기 치열한 경쟁을 펼쳤던 티몬과 위메프는... ◆위메프 &quot;내실 경영으로 충성고객 잡는다&quot; 지난해 가장 공격적인 마케팅 활동을 펼쳤던 위메프는 올해... 특히 위메프는 지난 4월 소셜커머스 업계에서 끊임없이...");
		news.setImage("image=http://imgnews.naver.net/image/thumb140/031/2014/06/09/322871.jpg");
		news.setDate("2014-06-09 18:06:00.0");
		news.setLink("http://www.inews24.com/php/news_view.php?g_serial=827209&g_menu=020310&rrf=nv");
		news.setProvider("아이뉴스24");
		news.setRelationScore(4);
		allNewsList.add(news);

		boolean isContainSeparator = allNewsList.get(FIRST_INDEX).getPreview().contains(PREVIEW_SEPARATOR);
		assertTrue(isContainSeparator);

		when(newsDao.getNewsList("2014-06-09")).thenReturn(allNewsList);
		List<News> filteredAllNewsList = newsService.getNewsList("2014-06-09");

		assertNotNull(filteredAllNewsList);

		isContainSeparator = filteredAllNewsList.get(FIRST_INDEX).getPreview().contains(PREVIEW_SEPARATOR);
		assertTrue(!isContainSeparator);
	}
}
