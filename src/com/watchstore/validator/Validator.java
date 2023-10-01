package com.watchstore.validator;

import java.sql.*;

import com.watchstore.dfHandler.dbConnection;

public class Validator {

	
	public static boolean validUser(String email,String password) {
		Connection conn=dbConnection.getConnection();
		String sql="SELECT email,password from users where email=?";
		boolean res=false;
		try {

			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet r=ps.executeQuery();
			r.next();
			if(password.equals(r.getString("password"))){
				res=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		
		}
		finally {
			return res;
		}
		
	}
}
