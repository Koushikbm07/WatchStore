package com.watchstore.functionality;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dbConnection;
import com.watchstore.dfHandler.dbinjector;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String userType=request.getParameter("usertype");
		
		try {
			
			dbinjector.addUser(uname, email, password, gender, userType);
			response.sendRedirect("login.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Registration Failed");
			response.sendRedirect("register.jsp");
		}
	
		
	}

}
