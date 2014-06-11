package kr.co.tmon.social.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.co.tmon.social.api.vo.News;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author 정승현 - RASPILLA16@tmon.co.kr
 * 
 */
@Service
public class NewsFilteringService {
	private static final int CUT_LINE = 0;
	private static final float BASE_SIMILARITY = 0.4f;
	private static final int TIME_MILLIS_A_DAY = 1000 * 60 * 60 * 24;
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String REGEX_FILTER = "[^a-zA-Z0-9가-힣\\s]";
	private static final String REGEX_SEPERATOR = "\\s{1,}";
	private static final String BLANK = " ";

	private Logger logger = Logger.getLogger(this.getClass());

	public void filterNewsList(List<News> newsList) throws Exception {
		List<WordsAndScore> wordsAndScoreList = makeWordsAndScoreList(newsList);
		initWordsAndScore(newsList, wordsAndScoreList);

		logBeforeFiltering(newsList, wordsAndScoreList);
		removeNewsBelowCutLine(newsList, wordsAndScoreList);
		logAfterFiltering(newsList);
	}

	private List<WordsAndScore> makeWordsAndScoreList(List<News> newsList) {
		List<WordsAndScore> wordsAndScoreList = new ArrayList<WordsAndScore>();
	
		for (News news : newsList) {
			String[] stringArray = news.getTitle().replaceAll(REGEX_FILTER, BLANK).trim().split(REGEX_SEPERATOR);
			wordsAndScoreList.add(new WordsAndScore(stringArray));
		}
	
		return wordsAndScoreList;
	}

	private void initWordsAndScore(List<News> newsList, List<WordsAndScore> wordsAndScoreList) throws ParseException {
		for (int pivot = 0; pivot < newsList.size(); pivot++) {
			WordsAndScore pivotWordsAndScore = wordsAndScoreList.get(pivot);

			for (int target = 0; target < newsList.size(); target++) {
				if (pivot == target)
					continue;

				if (getTimeGap(pivot, target, newsList) > TIME_MILLIS_A_DAY)
					continue;

				int totalLenth = 0;
				int matchedLenth = 0;

				for (String targetWord : wordsAndScoreList.get(target).wordArray) {
					totalLenth += targetWord.length();
					char[] targetCharArray = targetWord.toCharArray();

					for (String pivotWord : pivotWordsAndScore.wordArray) {
						int limit = Math.min(pivotWord.length(), targetWord.length());
						char[] pivotCharArray = pivotWord.toCharArray();

						for (int index = 0; index < limit; index++)
							if (pivotCharArray[index] == targetCharArray[index])
								matchedLenth++;
					}
				}

				if ((float) matchedLenth / (float) totalLenth > BASE_SIMILARITY) {
					if (target > pivot)
						pivotWordsAndScore.score++;

					pivotWordsAndScore.similarNewsCount++;
				}
			}
		}
	}

	private void removeNewsBelowCutLine(List<News> newsList, List<WordsAndScore> wordsAndScoreList) {
		for (int index = newsList.size() - 1; index >= 0; index--) {
			WordsAndScore wordsAndScore = wordsAndScoreList.get(index);

			if (wordsAndScore.score > CUT_LINE)
				newsList.remove(index);
			else
				newsList.get(index).setSimilarNews(wordsAndScore.similarNewsCount);
		}
	}

	private long getTimeGap(int pivot, int target, List<News> newsList) throws ParseException {
		String pivotTimeString = newsList.get(pivot).getDate();
		String targetTimeString = newsList.get(target).getDate();

		long pivotTime = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(pivotTimeString).getTime();
		long targetTime = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(targetTimeString).getTime();

		return Math.abs(pivotTime - targetTime);
	}

	private void logAfterFiltering(List<News> newsList) {
		logger.info("-------------------------------------");
		logger.info("필터링 후 사이즈 : " + newsList.size());
		for (News news : newsList) {
			logger.info(">> 뉴스 제목 : " + news.getTitle());
		}
	}

	private void logBeforeFiltering(List<News> newsList, List<WordsAndScore> wordsAndScoreList) {
		logger.info("필터링 전 사이즈 : " + newsList.size());
		for (int index = newsList.size() - 1; index >= 0; index--) {
			logger.info(">> 점수 : " + wordsAndScoreList.get(index).score + "	// 뉴스 제목 : " + newsList.get(index).getTitle());
		}
	}

	private static class WordsAndScore {
		private String[] wordArray;
		private int score;
		private int similarNewsCount;

		private WordsAndScore(String[] wordArray) {
			this.wordArray = wordArray;
		}

		@Override
		public String toString() {
			return "WordsAndScore [wordArray=" + Arrays.toString(wordArray) + ", score=" + score + ", similarNewsCount=" + similarNewsCount + "]";
		}
	}
}
