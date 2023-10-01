package com.watchstore.dfHandler;

import java.sql.*;

public class dbinjector {


	public static void addUser(String uname,String email,String pass,String gender,String userType){
		
		
		String sql="INSERT INTO users(id,name,email,password,gender,type) VALUES(userid.nextval,?,?,?,?,?)";
		try {
			

	
			Connection conn = dbConnection.getConnection();
	
		PreparedStatement ps=conn.prepareStatement(sql); 
			ps.setString(1,uname);
			ps.setString(2,email);
			ps.setString(3,pass);
			ps.setString(4,gender);
			ps.setString(5,userType);
			
			ps.executeQuery();
			
			conn.close();
		}
		catch (Exception e){
			System.out.print("Cannot add Customer to Database");
			e.printStackTrace();
		}
		
	}
	
	public static boolean addProduct(String pid,String pname,String pdesc,String pprice, String pimg,String pstock) {
		
		String sql="INSERT INTO products VALUES(?,?,?,?,?,?)";
		
		
		try {
			Connection conn = dbConnection.getConnection();
			
			PreparedStatement rs=conn.prepareStatement(sql);	
			rs.setInt(1,Integer.parseInt(pid));
			rs.setString(2, pname);
			rs.setString(3, pdesc);
			rs.setInt(4,Integer.parseInt(pprice));
			rs.setString(5, pimg);
			rs.setInt(6, Integer.parseInt(pstock));
			rs.executeUpdate();
			conn.close();
			return true;
			
		}
		catch (Exception e) {
			System.out.println("Cannot add product , try Again");
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	public static boolean deleteProduct(String pid) {
		
		String sql="DELETE FROM products WHERE PID=?";
		boolean status=false;
		
		try {
			Connection conn = dbConnection.getConnection();
			
			PreparedStatement rs=conn.prepareStatement(sql);
			rs.setInt(1, Integer.parseInt(pid));
			rs.executeUpdate();
			conn.close();

			status=true;
			
		}
		catch (Exception d) {
			d.printStackTrace();
			System.out.println("Cannot delete the product");
			
		}
		finally {
			return status;
		}
		
	}
	public static boolean updatePassword(String mail,String pass ){
		String sql="UPDATE CUSTOMERS SET pass=? WHERE mail=? ";
		boolean status=false;
		
		try {
			Connection conn = dbConnection.getConnection();
			
			PreparedStatement rs=conn.prepareStatement(sql);
			rs.setString(1,pass);
			rs.setString(2,mail);
			rs.executeUpdate();
			conn.close();

			status=true;
			
		}
		catch (Exception d) {
			d.printStackTrace();
			System.out.println("Cannot change the password");
			
		}
		finally {
			return status;
		}
		

	}
	
	
}
