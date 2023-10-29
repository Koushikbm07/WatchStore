package com.watchstore.functionality;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchstore.model.Cart;


@WebServlet("/remove-cart")
public class RemoveCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(request.getParameter("pid"));
		HttpSession session=request.getSession();
		
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cart-list");
		Iterator itr=cartList.iterator();
		
		while(itr.hasNext()) {
			Cart cart=(Cart) itr.next();
			if(cart.getId()==pid) {
				itr.remove();
				response.sendRedirect("cart.jsp");
			}
			
		}
		
		
	}

}
