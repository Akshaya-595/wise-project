package com.rest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class AccessInfo {
	@Id
	private int noOfPages;
	private String authorName;
	private String links;
	
	@OneToOne(mappedBy="accessinfo") //Mapping of ScoreBoard
	@JoinColumn(name="finalRank")
	ScoreBoard scoreboard;
	
	public AccessInfo(){
		
	}
	public AccessInfo(String authorName, int noOfPages, String links) {
		super();
		this.authorName = authorName;
		this.noOfPages = noOfPages;
		this.links = links;
	}
	
	public ScoreBoard getScoreboard() {
		return scoreboard;
	}
	public void setScoreboard(ScoreBoard scoreboard) {
		this.scoreboard = scoreboard;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	@Override
	public String toString() {
		return "AccessInfo [authorName=" + authorName + ", noOfPages=" + noOfPages + ", links=" + links
				+ ", scoreboard=" + scoreboard + "]";
	}
}
