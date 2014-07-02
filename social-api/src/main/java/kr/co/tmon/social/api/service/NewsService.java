package kr.co.tmon.social.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kr.co.tmon.social.api.dao.NewsDao;
import kr.co.tmon.social.api.vo.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 강이경
 * 
 *         DAO 에서 NewsList를 가져와 Controller에 전달하는 클래스
 */
@Service
public class NewsService {
	private static final String PREVIEW_SEPARATOR = "(PREVIEW_SEPARATOR)";
	private static final String TMON = "티켓몬스터";
	private static final String COUPANG = "쿠팡";
	private static final String WEMAKEPRICE = "위메프";
	private static final int NO_OCCURRENCE = -1;

	@Autowired
	private NewsDao newsDao;

	public List<News> getNewsList(String date) {
		List<News> allNewsList = new ArrayList<>();
		List<News> tmonNewsList = new ArrayList<>();
		List<News> coupangNewsList = new ArrayList<>();
		List<News> wemakepriceNewsList = new ArrayList<>();

		allNewsList = newsDao.getNewsList(date);

		categorizeNewsAsCorp(allNewsList, tmonNewsList, coupangNewsList, wemakepriceNewsList);

		setNewsPreview(tmonNewsList, coupangNewsList);

		List<News> filteredAllNewsList = new ArrayList<>();
		filteredAllNewsList.addAll(tmonNewsList);
		filteredAllNewsList.addAll(coupangNewsList);
		filteredAllNewsList.addAll(wemakepriceNewsList);

		Collections.sort(filteredAllNewsList, new DateDescCompare());

		return filteredAllNewsList;
	}

	private void categorizeNewsAsCorp(List<News> allNewsList, List<News> tmonNewsList, List<News> coupangNewsList, List<News> wemakepriceNewsList) {
		boolean isTmonNews;
		boolean isCoupangNews;
		boolean isWemakepriceNews;

		for (News news : allNewsList) {
			isTmonNews = false;
			isCoupangNews = false;
			isWemakepriceNews = false;

			String[] socialNames = news.getSocialName().split(",");
			for (String socialName : socialNames) {
				if (socialName.equals(TMON))
					isTmonNews = true;
				else if (socialName.equals(COUPANG))
					isCoupangNews = true;
				else if (socialName.equals(WEMAKEPRICE))
					isWemakepriceNews = true;
			}

			if (isTmonNews == true)
				tmonNewsList.add(news);
			else if (isCoupangNews == true)
				coupangNewsList.add(news);
			else if (isWemakepriceNews == true)
				wemakepriceNewsList.add(news);
		}
	}

	private void setNewsPreview(List<News> tmonNewsList, List<News> coupangNewsList) {
		for (News news : tmonNewsList) {
			int indexOfChar = news.getPreview().indexOf(PREVIEW_SEPARATOR);
			if (indexOfChar != NO_OCCURRENCE)
				news.setPreview(news.getPreview().substring(0, indexOfChar));
		}

		for (News news : coupangNewsList) {
			int indexOfChar = news.getPreview().indexOf(PREVIEW_SEPARATOR);
			if (indexOfChar != NO_OCCURRENCE) {
				news.setPreview(news.getPreview().substring(0, indexOfChar));
			}
		}
	}

	static class DateDescCompare implements Comparator<News> {

		@Override
		public int compare(News o1, News o2) {
			return o2.getDate().compareTo(o1.getDate());
		}

	}
}
