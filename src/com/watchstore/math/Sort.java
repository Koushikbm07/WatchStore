package com.watchstore.math;
import com.watchstore.model.*;
import java.util.*;
import java.util.Comparator;
public class Sort {
		
	public static List<Product> lowToHigh(List<Product> products){
		 

		Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
		return products;
	
	}
	public static List<Product> highToLow(List<Product> products){
		
		
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
		return products;
		
	}
	
}
