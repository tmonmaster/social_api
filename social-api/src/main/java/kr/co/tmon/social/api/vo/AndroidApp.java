package kr.co.tmon.social.api.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 정승현 - RASPILLA16@tmon.co.kr
 * 
 */
@XmlRootElement(name = "app")
@XmlAccessorType(XmlAccessType.FIELD)
public class AndroidApp {
	private String appName;
	private String averageScore;
	private String ranking;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(String averageScore) {
		this.averageScore = averageScore;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "AndroidApp [appName=" + appName + ", averageScore=" + averageScore + ", ranking=" + ranking + "]";
	}
}
