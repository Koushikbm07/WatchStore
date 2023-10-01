package com.watchstore.dfHandler;


import java.sql.*;


public  class dbConnection {
	public  static Connection getConnection() {
		
		String driver="oracle.jdbc.driver.OracleDriver";
		 String url="jdbc:oracle:thin:@localhost:1521:xe";
		String User="watchstore";
		 String Pass="watchstore";
		 Connection conn=null;
		try {
			 Class.forName(driver);
			 conn= DriverManager.getConnection(url,User,Pass);	
			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DataBase Failed to Connect ");
		}
		return conn;
		
	}
	

	
	
	}
	


