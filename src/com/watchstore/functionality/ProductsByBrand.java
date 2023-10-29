package com.watchstore.functionality;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.model.Product;

/**
 * Servlet implementation class ProductsByBrand
 */
@WebServlet("/brand/*")
public class ProductsByBrand extends HttpServlet {

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {


		String par = request.getParameter("bid");
		List<Product> products=null;
		int bid = -1;
		try {
			
		if (par != null) {
			bid = Integer.parseInt(par);
			products = dfFetcher.getProductsByBrandId(bid);
			request.setAttribute("productsByBrandId", products);
			RequestDispatcher rq = request.getRequestDispatcher("/productsbybrand.jsp");
			rq.forward(request, response);
		}
		else {
			
	        response.sendRedirect(request.getContextPath() + "/");
		}

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something Wrong in ProductsByBrandID Servlets");
		}
	}

}
