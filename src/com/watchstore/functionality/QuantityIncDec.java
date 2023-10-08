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

import com.watchstore.model.Cart;


@WebServlet("/q-inc-dec")
public class QuantityIncDec extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		
		ArrayList<Cart> cartList=(ArrayList<Cart>)session.getAttribute("cart-list");
		Iterator itr=cartList.iterator();
		while(itr.hasNext()) {
			Cart cart=(Cart)itr.next();
			if(action.equals("dec") && cart.getQuantity()>1) {
					cart.setQuantity(cart.getQuantity()-1);
					break;
			}
			else if(action.equals("inc")){
				cart.setQuantity(cart.getQuantity()+1);
				break;

			}
			
		}
		response.sendRedirect("cart.jsp");
		
	}

}
