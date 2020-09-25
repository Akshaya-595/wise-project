package com.ts.dao;

import com.rest.dto.ScoreBoard;
import com.ts.db.HibernateTemplate;

public class ScoreBoardDAO {
	
	public int ViewScore(ScoreBoard score) {
		return HibernateTemplate.addObject(score);
	}
	
}
