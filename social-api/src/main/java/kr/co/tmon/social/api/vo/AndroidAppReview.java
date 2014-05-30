package kr.co.tmon.social.api.vo;

/**
 * @author raspilla16@tmon.co.kr
 * 
 */
public class AndroidAppReview {
	private String reviewLink;
	private String userName;
	private String userLink;
	private String reviewDate;
	private String starScore;
	private String reviewTitle;
	private String reviewContent;
	private String companyName;
	
	public AndroidAppReview(){};
	
	public AndroidAppReview(String reviewLink, String userName, String userLink, String reviewDate, String starScore, String reviewTitle, String reviewContent, String companyName) {
		this.reviewLink = reviewLink;
		this.userName = userName;
		this.userLink = userLink;
		this.reviewDate = reviewDate;
		this.starScore = starScore;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.companyName = companyName;
	}

	public String getReviewLink() {
		return reviewLink;
	}

	public void setReviewLink(String reviewLink) {
		this.reviewLink = reviewLink;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLink() {
		return userLink;
	}

	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getStarScore() {
		return starScore;
	}

	public void setStarScore(String starScore) {
		this.starScore = starScore;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "AndroidAppReview [reviewLink=" + reviewLink + ", userName=" + userName + ", userLink=" + userLink + ", reviewDate=" + reviewDate + ", starScore=" + starScore + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent + ", companyName=" + companyName + "]";
	}	
}
