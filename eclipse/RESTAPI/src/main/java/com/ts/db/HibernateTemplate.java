package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.rest.dto.AccessInfo;
import com.rest.dto.Questions;
import com.rest.dto.User;

public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static User getObject(Class User,Serializable serializable)
	{
		User user=null;
		
		try {			
			return (User) sessionFactory.openSession().get(User.class,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static User getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from User where email = :loginId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  User user = (User)queryResult;
	  return user; 
	}
	public static User getObjectByEmail(String loginId) {
		
		String queryString = "from User where userName = :loginId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  Object queryResult = query.uniqueResult();
		  User user = (User)queryResult;
		  return user; 
		}
	
	public static List<User> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(User user)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(user);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class Questions,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Questions ques=(Questions) session.get(Questions,serializable);
			
			session.delete(ques);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<User> getObjectListByName(Class User, String userName, String password) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(User);
			Criterion nameCriterion = Restrictions.eq(userName, password);
			criteria.add(nameCriterion);
			return criteria.list();
	}

	public static AccessInfo getObjectBygetAccess(String authorName, int noOfPages, String links) {
		String queryString = "from AccessInfo where author = :authorName , pages = :noOfPages and URLs = :links " ;
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("authorName", authorName);
		query.setInteger("noOfPages", noOfPages);
		query.setString("links", links);
		Object queryResult = query.uniqueResult();
		AccessInfo accessinfo = (AccessInfo)queryResult;
		return accessinfo; 
	}
}
