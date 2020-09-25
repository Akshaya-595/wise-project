package com.ts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bvrit2018","root","12345");
			if(con!=null)
				System.out.println("Connectionsuccess");
			return con;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
