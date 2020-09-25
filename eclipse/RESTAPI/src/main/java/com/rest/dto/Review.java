package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Review {
	@Id
	private int rating;
	private String comments;
	
	@OneToOne
	@JoinColumn(name="userName")
	User user;
	
	public Review(){
		
	}
	public Review(int rating, String comments) {
		super();
		this.rating = rating;
		this.comments = comments;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Review [rating=" + rating + ", comments=" + comments + ", user=" + user + "]";
	}
}
