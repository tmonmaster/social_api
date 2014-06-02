package kr.co.tmon.social.api.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * JAXB로 Marshalling 할 대상 클래스
 * 
 * @author u_kino07
 * 
 */
@XmlRootElement(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootNews {

	@XmlElement(name = "itemCount")
	private int newsListSize;

	@XmlElement(name = "item")
	private List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
		this.newsListSize = newsList.size();
	}

	@Override
	public String toString() {
		return "RootNews [newsList=" + newsList + "]";
	}
}
