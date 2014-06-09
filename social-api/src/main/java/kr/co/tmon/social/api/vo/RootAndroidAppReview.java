package kr.co.tmon.social.api.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "androidReview")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootAndroidAppReview {

	@XmlElementWrapper(name = "scoreList")
	@XmlElement(name = "score")
	private List<AndroidApp> scoreList;
	@XmlElementWrapper(name = "reviewList")
	@XmlElement(name = "review")
	private List<AndroidAppReview> reviewList;

	public RootAndroidAppReview() {} // JAXB 마샬링에 필요한 기본 생성자

	public void setReviewList(List<AndroidAppReview> reviewList) {
		this.reviewList = reviewList;
	}

	public void setAverageScoreList(List<AndroidApp> averageScoreList) {
		this.scoreList = averageScoreList;
	}
}
