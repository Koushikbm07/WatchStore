package com.watchstore.math;
import com.watchstore.model.*;
import java.util.*;
public class Calculate {

	
	public static int getTotalCartMRP(List<Cart> carts) {
		int total=0;
		for(Cart cart:carts) {
			total+=cart.getPrice()*cart.getQuantity();
		}
		return total;
	}
	public static int getTotalCartDiscount(List<Cart> carts) {
		int total=0;
		for(Cart cart:carts) {
			total+=cart.getDiscount();
		}
		return total;
	}
	public static int getTotalCart(List<Cart> carts) {
		int mrp=getTotalCartMRP(carts);
		int discount=getTotalCartDiscount(carts);
		int total=0;
		if(mrp<500) {
			total=mrp-discount+100;
			
		}else {
			total=mrp-discount;
		}
		return total;
		
		
	}
}
