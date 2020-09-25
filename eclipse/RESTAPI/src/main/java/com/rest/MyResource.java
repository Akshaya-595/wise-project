package com.rest;

import javax.ws.rs.Consumes;
//import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.AccessInfo;
import com.rest.dto.Category;
//import com.rest.dto.Department;
import com.rest.dto.Questions;
import com.rest.dto.Review;
import com.rest.dto.ScoreBoard;
import com.rest.dto.User;
import com.ts.dao.AccessInfoDAO;
import com.ts.dao.CategoryDAO;
//import com.ts.dao.DeptDAO;
import com.ts.dao.QuestionsDAO;
import com.ts.dao.ReviewDAO;
import com.ts.dao.ScoreBoardDAO;
import com.ts.dao.UserDAO;

@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @Path("Hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Hello ! Welcome to REST API";
    }
    
	@Path("Hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHi(){
    	return "Hi! Welcome to REST API";
    }
    /*@Path("registerUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User registerUser() {
    	User user = new User();
    	user.setUserId(1);
    	user.setUserName("Pravallika");
    	user.setMobileNo(790146353);
    	user.setPassword("password");
    	UserDAO userDAO = new UserDAO();
    	userDAO.register(user);
    	return user;
    }*/
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void resisterUser(User employee) {
		System.out.println("Data Recieved in Register : " + employee); 
		UserDAO userDao = new UserDAO();
		userDao.register(employee); 
	}
	
	
    @Path("registerCategory")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category registerCategory() {
    	User user = new User();
    //	user.setUserId(1);
    	user.setUserName("Pravallika");
    	user.setMobileNo(790146353);
    	user.setPassword("password");
    	Category cat = new Category();
    	cat.setCId(2);
    	cat.setcName("Novel");
    	cat.setUser(user);
    	CategoryDAO catDAO = new CategoryDAO();
    	catDAO.register(cat);
    	return cat;
    }
    
    @Path("AddQuestions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Questions AddQuestions() {
    	Category cat = new Category();
    	cat.setCId(1);
    	cat.setcName("easy");
    	Questions ques = new Questions();
    	ques.setQId(1);
    	ques.setLevels("easy");
    	ques.setBit("what is the actual name of HarryPotter?");
    	ques.setCategory(cat);
    	QuestionsDAO quesDAO = new QuestionsDAO();
    	quesDAO.Add(ques);
    	return ques;
    }
    
    @Path("deleteQues/{QId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Questions deleteQues(@PathParam("QId") int QId){
		System.out.println("Data Recieved in delete : " + QId);
		Questions ques = new Questions(); 
    	QuestionsDAO quesDAO = new QuestionsDAO();
    	quesDAO.delete(ques);
    	return ques;

	}	
    
    @Path("AddReviews")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Review AddReviews() {
    	User user = new User();
    	//user.setUserId(1);
    	user.setUserName("Pravallika");
    	user.setMobileNo(790146353);
    	user.setPassword("password");
    	Review review = new Review();
    	review.setComments("Good");
    	review.setUser(user);
    	review.setRating(10);
    	ReviewDAO reviewDAO = new ReviewDAO();
    	reviewDAO.AddReview(review);
    	return review;
    }
    
    @Path("AccessExtraInfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AccessInfo AccessExtraInfo() {
    	AccessInfo accessinfo = new AccessInfo();
    	ScoreBoard scoreboard = new ScoreBoard();
    	accessinfo.setScoreboard(scoreboard);
    	accessinfo.setAuthorName("J. K. Rowling");
    	accessinfo.setNoOfPages(100);
    	accessinfo.setLinks("https://onionplay.co/harry-potter-collection/");
    	AccessInfoDAO accessDAO = new AccessInfoDAO();
    	accessDAO.getAccess(accessinfo);
    	scoreboard.setfinalRank(2);
    	scoreboard.setTimeTaken("180sec");
    	return accessinfo;
    	
    }
   @Path("getUserById/{loginId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("loginId") String loginId){
		System.out.println("Recieved in getEmployeeByID : " + loginId); 
		UserDAO residentDaoH = new UserDAO();
		 User user = residentDaoH.getUserByloginId(loginId);
		 System.out.println(user);
		 return user;
		
	}
   
   
   
    @Path("ViewScores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ScoreBoard ViewScores() {
    	User user = new User();
    //	user.setUserId(1);
    	user.setUserName("Pravallika");
    	user.setMobileNo(790146353);
    	user.setPassword("password");
    	AccessInfo accessinfo = new AccessInfo();
    	accessinfo.setNoOfPages(100);
    	accessinfo.setLinks("https://onionplay.co/harry-potter-collection/");
    	ScoreBoard scoreboard = new ScoreBoard();
    	accessinfo.setAuthorName("J. K. Rowling");
    	scoreboard.setTimeTaken("180sec");
    	scoreboard.setUser(user);
    	scoreboard.setfinalRank(2);
    	scoreboard.setAccessinfo(accessinfo);
    	ScoreBoardDAO scoreboardDAO = new ScoreBoardDAO();
    	scoreboardDAO.ViewScore(scoreboard);
    	Questions ques = new Questions();
    	scoreboard.setQuestions(ques);
    	ques.setQId(1);
    	ques.setLevels("easy");
    	ques.setBit("what is the actual name of HarryPotter?");
    	return scoreboard;
    }
    // Use This myresource for your project building
}
