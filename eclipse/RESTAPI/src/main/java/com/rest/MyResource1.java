package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.User;
import com.ts.dao.UserDAO;

@Path("myresource1")
public class MyResource1 {
    @Path("aks")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    @Path("regUser")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
     public void registerUser(){
    	
    	User user = new User("aish",99632,"aish");
    	UserDAO obj = new UserDAO();
    	obj.register(user);
    	System.out.println("akshayaa");
    }
}
    //@Path("regEmp")
    //@GET
    //@Produces(MediaType.TEXT_PLAIN)
    /*public String daoTest() {
    	Department dept = new Department();
    	dept.setDeptId(1);
    	dept.setDeptName("ACCOUNTS");
    	dept.setLocation("HYDERABAD");
    	DeptDAO deptDao = new DeptDAO();
    	deptDao.register(dept); */
    	
//    	Employee emp=new Employee();
//    	emp.setEmpId(100);
//    	emp.setEmpName("PASHA");
//    	emp.setEmail("dummy@gmail.com");
//    	emp.setJoinDate(new java.util.Date());
//    	emp.setDepartment(dept);
//    	
//    	EmployeeDAO empDao = new EmployeeDAO();
//    	empDao.register(emp);
    	//return "Success";
    

