package kr.co.tmon.social.api.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Yunho Lee
 * 
 *         DB에서 가져온 뉴스 데이터를 담는 객체
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class News {
	@XmlElement(name = "socialName")
	private String socialName;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "preview")
	private String preview;
	@XmlElement(name = "image")
	private String image;
	@XmlElement(name = "date")
	private String date;
	@XmlElement(name = "link")
	private String link;
	@XmlElement(name = "provider")
	private String provider;
	@XmlElement(name = "similarNews")
	private int similarNews;
	private int relationScore;	

	public News() {}

	public News(String socialName, String title, String preview, String image, String date, String link, String provider) {
		this.socialName = socialName;
		this.title = title;
		this.preview = preview;
		this.image = image;
		this.date = date;
		this.link = link;
		this.provider = provider;
	}

	public int getSimilarNews() {
		return similarNews;
	}

	public void setSimilarNews(int similarNews) {
		this.similarNews = similarNews;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getRelationScore() {
		return relationScore;
	}

	public void setRelationScore(int relationScore) {
		this.relationScore = relationScore;
	}

	@Override
	public String toString() {
		return "News [socialName=" + socialName + ", title=" + title + ", preview=" + preview + ", image=" + image + ", date=" + date + ", link=" + link + ", provider=" + provider + ", similarNews=" + similarNews + ", relationScore=" + relationScore + "]";
	}
}
