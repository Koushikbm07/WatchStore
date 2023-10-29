package com.watchstore.functionality;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.model.Cart;
import com.watchstore.model.Product;

/**
 * Servlet implementation class AddToWishList
 */
@WebServlet("/wishlist")
public class AddToWishList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product=null;
		int pid=-1;
		try {
			
		 pid=Integer.parseInt(request.getParameter("pid"));
		 product=dfFetcher.getProductbyId(pid);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something wrong in AddToWishList Servlets");
		}
		HttpSession session=request.getSession();
		List<Product> wishList=(List<Product>)request.getSession().getAttribute("wishlist");
		ArrayList<Cart> cartlist=(ArrayList<Cart>)session.getAttribute("cart-list");
		List<Product> wishlist=new ArrayList<Product>();
		
		if(wishList==null) {
			wishlist.add(product);
			session.setAttribute("wishlist", wishlist);
		}
		else {
			wishlist=wishList;
			boolean exist=false;
			for (Product w : wishlist) {
				if(w.getId()==pid){
					exist=true;
					break;
				}
			
			}
			if (!exist) {
				wishlist.add(product);
			}
		}
		boolean inCart=false;
		if(cartlist!=null) {
		for(Cart cart:cartlist) {
			if(cart.getId()==pid) {
				inCart=true;
			}
		}
		}
		if(inCart) {
			response.sendRedirect("remove-cart?pid="+pid);
		}else {
			
			response.sendRedirect("wishlist.jsp");
		}
		
	}	

}
