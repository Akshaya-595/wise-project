package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table (name="USER")
public class User {
	//@Id@GeneratedValue
	//private int userId;
	@Id
	private String userName;
	private int mobileNo;
	private String password;
	
//	@OneToOne(mappedBy="user") //Mapping of Category
//	@JoinColumn(name="CId")
//	Category category;
		
//	@OneToOne(mappedBy="user")                 //Mapping of Review
//	@JoinColumn(name="rating")
//	Review review;
	
	@OneToOne(mappedBy="user") //Mapping of ScoreBoard
	@JoinColumn(name="finalRank")
	ScoreBoard scoreboard;
	
	public User(){
		super();
	}
	public User( String userName, int mobileNo, String password) {
		super();
	//	this.userId = userId;
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	
	//public int getUserId() {
		//return userId;
	//}
	//public  void setUserId(int userId) {
		//this.userId = userId;
	//}
//	public Review getReview() {
//		return review;
//	}
//	public void setReview(Review review) {
//		this.review = review;
//	}
	public ScoreBoard getScoreboard() {
		return scoreboard;
	}
	public void setScoreboard(ScoreBoard scoreboard) {
		this.scoreboard = scoreboard;
	}
//	public Category getCategory() {
	//	return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//	@Override
//	public String toString() {
	//	return "User [userId=" + userId + ", userName=" + userName + ", mobileNo=" + mobileNo + ", password=" + password
		//		+ ", category=" + category + ", review=" + review + ", scoreboard=" + scoreboard + "]";
	//}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobileNo=" + mobileNo + ", password=" + password + ", scoreboard="
				+ scoreboard + "]";
	}

}
