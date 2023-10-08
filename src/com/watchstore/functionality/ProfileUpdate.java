package com.watchstore.functionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.watchstore.validator.Validator;


@MultipartConfig
@WebServlet("/profile-update")
public class ProfileUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part photo=request.getPart("photo");
		String photoName=Validator.addImage(photo, "user");
		String uname=request.getParameter("uname");
		
		
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Profile Not Updated");
		}
		finally {
			response.sendRedirect("account.jsp");
		}
	}

}
