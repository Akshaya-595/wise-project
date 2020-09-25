package com.ts.dao;

import com.rest.dto.Review;
import com.ts.db.HibernateTemplate;

public class ReviewDAO {

	public int AddReview(Review review) {
		return HibernateTemplate.addObject(review);
	}
	
	

}
