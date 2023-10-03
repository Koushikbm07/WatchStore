package com.watchstore.validator;

import java.sql.*;
import java.util.List;

import javax.servlet.http.Part;

import com.watchstore.dfHandler.dbConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
			System.out.println("User Not Validated");
			e.printStackTrace();
			
		
		}
		finally {
			return res;
		}
		
	}
	static public  String addImage(Part file,String type) throws IOException {
		String uploadPath;
		String imageFileName=file.getSubmittedFileName();
		
		if(type.equalsIgnoreCase("product")) {
			
			 uploadPath="D:/Koushik_GitHub_Local/WatchStore/watchstore/WebContent/images/products/"+imageFileName;  
		}
		else {
			 uploadPath="D:/Koushik_GitHub_Local/WatchStore/watchstore/WebContent/images/brands/"+imageFileName;  

		}
		
		
		
		try
		{
			
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=file.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Image Not Added");
		}
		finally {
			return imageFileName;
		}
		
		
	}
}
