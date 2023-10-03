package com.watchstore.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dbinjector;
import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.model.Brand;
import com.watchstore.validator.Validator;
@MultipartConfig
@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pname=request.getParameter("pname");
		String pdesc=request.getParameter("pdesc");
		int brandId=Integer.parseInt(request.getParameter("bid"));
		Part brand=request.getPart("bname");
		int pprice=Integer.parseInt(request.getParameter("pprice"));
		int discount=Integer.parseInt(request.getParameter("discount"));
		Part pimg=request.getPart("pimg");
		String pType=request.getParameter("ptype");
		int pstock=Integer.parseInt(request.getParameter("pstock"));
		boolean brandAdded=false;
		try {
		String pImageName=Validator.addImage(pimg, "product");
		String bImageName=Validator.addImage(brand, "brand");
		String[] brandName=bImageName.split("\\.");
		brandAdded=dbinjector.addBrand(brandId, brandName[0], bImageName);
		boolean productAdded=dbinjector.addProduct(pname, pdesc, pImageName, pprice, discount, pType, pstock,brandId);
		if(productAdded && brandAdded) {
			response.sendRedirect("index.jsp");
		}
		else {
			response.sendRedirect("admin.jsp");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Adding Product Failed");
			response.sendRedirect("cart.jsp");
			
		}
		
	}

}
