package com.ts.dao;

import com.rest.dto.AccessInfo;
import com.ts.db.HibernateTemplate;

public class AccessInfoDAO {
	
	public int getAccess(AccessInfo accessinfo) {
		
		return HibernateTemplate.addObject(accessinfo);
		
	}

}
