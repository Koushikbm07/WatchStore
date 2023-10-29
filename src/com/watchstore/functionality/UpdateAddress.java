package com.watchstore.functionality;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dbinjector;
import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.model.Address;
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
		String addressLine=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");	
		
		boolean updated=dbinjector.updateAddress(uid, street, addressLine, pincode, city, state);
		Address address=(Address)request.getSession().getAttribute("address");
		if(address!=null) {
			address.setStreet(street);
			address.setAddressLine(addressLine);
			address.setCity(city);
			address.setState(state);
			address.setPincode(Integer.parseInt(pincode));
			
		}
		
		if(updated) {
			response.sendRedirect("account.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/account.jsp");
			rd.forward(request, response);
		}
	
	}

}
