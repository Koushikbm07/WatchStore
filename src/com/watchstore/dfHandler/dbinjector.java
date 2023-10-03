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
	public static boolean addBrand(int bid,String bname,String bimg) {
		String sql="INSERT INTO brand values(?,?,?)";
		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setString(2, bname);
			ps.setString(3, bimg);
			ps.executeQuery();
			conn.close();
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Brand Not Added ");
		}
		return false;
		
	}
	public static boolean addProduct(String pname,String pdesc,String pimg ,int pprice,int discount,String pType,int pstock,int bid) {
		
		String sql="INSERT INTO product VALUES(prod.nextval,?,?,?,?,?,?,?,?)";
		
		
		try {
			Connection conn = dbConnection.getConnection();
			
			PreparedStatement rs=conn.prepareStatement(sql);	
			
			rs.setString(1, pname);
			rs.setString(2, pdesc);
			rs.setString(3, pimg);
			rs.setInt(4,pprice);
			rs.setInt(5,discount);
			rs.setString(6,pType);
			rs.setInt(7, pstock);
			rs.setInt(8, bid);
			rs.executeUpdate();
			conn.close();
			return true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot add product , try Again");
			
		}
		return false;
		
		
	}
	

	
	
}
