package com.watchstore.functionality;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dbConnection;
import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.validator.Validator;
import com.watchstore.model.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		boolean res=Validator.validUser(email,password);
		try {
		if(res ) {
			User user=dfFetcher.fetchUser(email, password);
			request.getSession().setAttribute("auth", user);
		
			response.sendRedirect("index.jsp");
			
		}
		else {
			System.out.println("Email and password dont match");
			response.sendRedirect("login.jsp");

		}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Login Failed");
			response.sendRedirect("login.jsp");
		}
		
	}

}
