package com.ts.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.rest.dto.Questions;
import com.ts.db.HibernateTemplate;

public class QuestionsDAO {
	
	public int Add(Questions ques) {
		//java.util.Date utilDate = new java.sql.Date(employee.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(ques);
	}

	public void delete(Questions ques) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		session.delete(ques); //insert query
		Transaction tx = session.beginTransaction();
		tx.commit(); //permanent save
		session.close();

		
	}

	

}
