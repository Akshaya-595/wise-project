package com.ts.dao;

import com.rest.dto.Category;
import com.ts.db.HibernateTemplate;

public class CategoryDAO {

	public int register(Category cat) {
		//java.util.Date utilDate = new java.sql.Date(employee.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(cat);
	}

}
