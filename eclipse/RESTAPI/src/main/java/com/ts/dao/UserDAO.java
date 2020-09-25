 package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.User;
import com.ts.db.HibernateTemplate;

public class UserDAO {
	
	private SessionFactory factory = null;

	public User getUserByPass(String loginId,String password) {

		return (User)HibernateTemplate.getObjectByUserPass(loginId,password);
	}

	public int register(User users) {
		return HibernateTemplate.addObject(users);
	}
	public int login(User users){
		return HibernateTemplate.addObject(users);
	}
	
	public List<User> getAllUsers() {
		List<User> users=(List)HibernateTemplate.getObjectListByQuery("From User");
		System.out.println("Inside All Users ..."+users);
		return users;	
	}

	public User getUser(int userId) {
		return (User)HibernateTemplate.getObject(User.class,userId);
	}


	public void getUsers(int Id) {
		String query= "from User where userId = Id";
		System.out.println("get users is called...");
		List<User> obj =(List<User>) HibernateTemplate.getObjectListByQuery(query);
		System.out.println("Testing get users :" + obj); 
		for(Object user: obj){
			User users = (User)user;
			System.out.println(users.getUserName());
		}
	}

	public User getUserByloginId(String loginId) {
		System.out.println("12345");
		return (User)HibernateTemplate.getObjectByEmail(loginId);
	}

}
