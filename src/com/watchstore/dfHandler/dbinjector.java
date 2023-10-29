package com.watchstore.dfHandler;

import java.sql.*;

import com.watchstore.model.User;

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
		catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Brand Already Present");
			
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
	
	public static boolean updateProfile(int id,String uname,String email,String gender,String phone,String photo) {
		String sql="UPDATE users SET name=?,email=?,gender=?,phone=?,photo=? WHERE id=?";
		
		try{
			Connection conn=dbConnection.getConnection();
			PreparedStatement pt=conn.prepareStatement(sql);
			pt.setString(1,uname);
			pt.setString(2, email);
			pt.setString(3, gender);
			pt.setString(4, phone);
			pt.setString(5, photo);
			pt.setInt(6, id);
			pt.executeQuery();
			conn.close();
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Profile Update Unsuccessfull");
		}
	
		return false;
		
	}
	public static boolean updateAddress(int id,String street,String address,String pincode,String city,String state) {
		String sql="UPDATE address SET street=?,address=?,pincode=?,city=?,state=?,country='INDIA' WHERE userid=?";
		
		try{
			
			Connection conn=dbConnection.getConnection();
			PreparedStatement pt=conn.prepareStatement(sql);
			pt.setString(1,street);
			pt.setString(2, address);
			pt.setString(3, pincode);
			pt.setString(4, city);
			pt.setString(5, state);
			pt.setInt(6, id);
			int res=pt.executeUpdate();
			conn.close();
			
			boolean updated=(res>=0)? true: false;
			System.out.println(updated);
			return updated;
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Address Update Unsuccessfull");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	public static boolean addUserId(int userId) throws SQLException {
		String sql="INSERT INTO address(userid) VALUES(?)";
		Connection conn=null;
		try {
			 conn=dbConnection.getConnection();
			PreparedStatement pt=conn.prepareStatement(sql);
			pt.setInt(1,userId);
			pt.executeQuery();
			
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("used id not added into address table ");
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		finally {
			conn.close();
		}
		return false;
	}

	
	
}
