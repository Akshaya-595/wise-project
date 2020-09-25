package com.rest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Questions {
	@Id
	private int QId;
	private String levels;
	private String bit;
	
	@ManyToOne
	@JoinColumn(name="CId")
	Category category;
	
	@OneToMany(mappedBy="questions",fetch = FetchType.LAZY)
	List<ScoreBoard> scoreboardList =new ArrayList<ScoreBoard>();
	
	public Questions(){
		
	}
	public Questions(int qId, String levels, String bit) {
		super();
		this.QId = qId;
		this.levels = levels;
		this.bit = bit;
	}

	public int getQId() {
		return QId;
	}

	public void setQId(int qId) {
		QId = qId;
	}

	public String getBit() {
		return bit;
	}

	public void setBit(String bit) {
		this.bit = bit;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public List<ScoreBoard> getScoreboardList() {
		return scoreboardList;
	}

	public void setScoreboardList(List<ScoreBoard> scoreboardList) {
		this.scoreboardList = scoreboardList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Questions [QId=" + QId + ", levels=" + levels + ", bit=" + bit + ", category=" + category
				+ ", scoreboardList=" + scoreboardList + "]";
	}
}
