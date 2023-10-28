package com.watchstore.functionality;

import java.io.IOException;
import java.util.*;

import com.watchstore.dfHandler.dfFetcher;
import com.watchstore.model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add-to-cart")
public class AddToCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try{
			ArrayList<Cart> CartList= new ArrayList<>();
			int pid=Integer.parseInt(request.getParameter("pid"));
			Cart cart = (Cart)dfFetcher.getProductbyId(pid);
			
			HttpSession session=request.getSession();
			
			ArrayList<Cart> cartlist=(ArrayList<Cart>)session.getAttribute("cart-list");
			List<Product> wishList=(List<Product>)session.getAttribute("wishlist");
			
			if(cartlist==null) {
				CartList.add(cart);
				session.setAttribute("cart-list", CartList);
				response.sendRedirect("index.jsp");
			}
			else {
				CartList=cartlist;
				boolean exist=false;
				for (Cart c : cartlist) {
					if(c.getId()==pid){
						exist=true;
						c.setQuantity(c.getQuantity()+1);
						
						
					}
				
				}
				if (!exist) {
					CartList.add(cart);
				}
			}
			if(wishList!=null) {
				for(Product product:wishList) {
					if(product.getId()==pid) {
						response.sendRedirect("remove-wishlist?pid="+pid);
					}
				}
			}
			response.sendRedirect("cart.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Add to Cart Failed");
		}
	}
		
		
	}


