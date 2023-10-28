package com.watchstore.functionality;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.model.User;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.getSession().removeAttribute("auth");
			User auth=(User)request.getSession().getAttribute("auth");

			if(auth==null) {
				response.sendRedirect("login.jsp");
			}
			else {
				response.sendRedirect("account.jsp");
			}
			
		}
		catch(Exception e) {
			System.out.println("Logout Failed");
			e.printStackTrace();
			
		}
	}

}
