package com.watchstore.functionality;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchstore.model.*;

/**
 * Servlet implementation class RemoveWishList
 */
@WebServlet("/remove-wishlist")
public class RemoveWishList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		HttpSession session=request.getSession();
		
		ArrayList<Product> wishList=(ArrayList<Product>)session.getAttribute("wishlist");
		Iterator itr=wishList.iterator();
		
		while(itr.hasNext()) {
			Product product=(Product)itr.next();
			if(product.getId()==pid) {
				itr.remove();
				response.sendRedirect("wishlist.jsp");
			}
			
		}
	}

}
