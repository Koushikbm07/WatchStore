package com.watchstore.functionality;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.watchstore.dfHandler.dbinjector;
import com.watchstore.model.User;
import com.watchstore.validator.Validator;


@MultipartConfig
@WebServlet("/profile-update")
public class ProfileUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part photo=request.getPart("photo");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String photoName=Validator.addImage(photo, "user");
		String uname=request.getParameter("uname");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		User auth=(User)request.getSession().getAttribute("auth");
		if(auth!=null) {
			auth.setUname(uname);
			auth.setPhone(phone);
			auth.setPhoto(photoName);
		}
		boolean updated=dbinjector.updateProfile(uid, uname, email, gender, phone, photoName);
		if(updated) {
			response.sendRedirect("account.jsp");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("/account.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
