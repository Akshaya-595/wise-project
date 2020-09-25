package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@XmlRootElement
@Entity
public class Category {
	@Id@GeneratedValue
	private int CId;
	private String cName; 
	
	@OneToOne
	@JoinColumn(name="userName")
	User user;
	
	@OneToMany(mappedBy="category",fetch = FetchType.LAZY)
	List<Questions> quesList =new ArrayList<Questions>();
	
	public Category(){
		
	}
	public Category(int cId, String cName) {
		super();
		this.CId = cId;
		this.cName = cName;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public List<Questions> getQuesList() {
		return quesList;
	}
	public void setQuesList(List<Questions> quesList) {
		this.quesList = quesList;
	}
}
