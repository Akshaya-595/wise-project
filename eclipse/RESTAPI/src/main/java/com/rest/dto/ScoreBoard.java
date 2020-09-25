package com.rest.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ScoreBoard {
	@Id
	private int finalRank;
	private String timeTaken;
	
	@OneToOne                        //Mapping of User
	@JoinColumn(name="userName")
	User user;
	
	@ManyToOne
	@JoinColumn(name="QId")
	Questions questions;
	
	@OneToOne
	@JoinColumn(name="noOfPages")
	AccessInfo accessinfo;
	
	public ScoreBoard(){
		
	}
	public ScoreBoard(int finalRank, String timeTaken) {
		super();
		this.finalRank = finalRank;
		this.timeTaken = timeTaken;
	}
	
	public AccessInfo getAccessinfo() {
		return accessinfo;
	}
	public void setAccessinfo(AccessInfo accessinfo) {
		this.accessinfo = accessinfo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public int getfinalRank() {
		return finalRank;
	}
	public void setfinalRank(int finalRank) {
		this.finalRank = finalRank;
	}
	public String getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}
	@Override
	public String toString() {
		return "ScoreBoard [rank=" + finalRank + ", timeTaken=" + timeTaken + ", user=" + user + ", questions=" + questions
				+ ", accessinfo=" + accessinfo + "]";
	}
}
