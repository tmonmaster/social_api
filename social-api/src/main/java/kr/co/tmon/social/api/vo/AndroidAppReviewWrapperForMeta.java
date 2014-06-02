package kr.co.tmon.social.api.vo;

import java.util.List;

/**
 * MetaData를 위해 생성한 래퍼 클래스
 * 
 * @author 강이경
 * 
 */
public class AndroidAppReviewWrapperForMeta {
	private int reviewCount;
	private List<AndroidAppReview> androidAppReviewList;

	public AndroidAppReviewWrapperForMeta(List<AndroidAppReview> androidAppReviewList) {
		this.reviewCount = androidAppReviewList.size();
		this.androidAppReviewList = androidAppReviewList;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public List<AndroidAppReview> getAndroidAppReviewList() {
		return androidAppReviewList;
	}

	public void setAndroidAppReviewList(
			List<AndroidAppReview> androidAppReviewList) {
		this.androidAppReviewList = androidAppReviewList;
	}
}
