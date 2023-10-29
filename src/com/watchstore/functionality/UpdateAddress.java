package com.watchstore.functionality;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dbinjector;
import com.watchstore.validator.Validator;

/**
 * Servlet implementation class UpdateAddress
 */
@WebServlet("/update-address")
public class UpdateAddress extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("userid"));
		String street=request.getParameter("street");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		boolean updated=dbinjector.updateAddress(uid, street, address, pincode, city, state);
		System.out.println(updated);
		if(updated) {
			response.sendRedirect("account.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/account.jsp");
			rd.forward(request, response);
		}
	
	}

}
