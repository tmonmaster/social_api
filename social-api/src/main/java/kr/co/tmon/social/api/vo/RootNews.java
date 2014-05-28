package kr.co.tmon.social.api.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * 
 *	JAXB로 Marshalling 할 대상 클래스
 * 
 * @author u_kino07
 *
 */
public class RootNews {

	@XmlElement(name = "item")
	private List<News> newsList;

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String toString() {
		return "RootNews [newsList=" + newsList + "]";
	}
}
