package com.watchstore.dfHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbEdit {
public static boolean deleteProduct(int pid) {
		
		String sql="DELETE FROM product WHERE pid=?";
		boolean status=false;
		
		try {
			Connection conn = dbConnection.getConnection();
			
			PreparedStatement rs=conn.prepareStatement(sql);
			rs.setInt(1, pid);
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
		String sql="UPDATE users SET password=? WHERE email=?";
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
