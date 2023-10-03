<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.watchstore.model.*" %>
    <%@page import="com.watchstore.dfHandler.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="styles/watches.css">
</head>
<body>


<%@include file="includes/nav.jsp"%>


    
    <div class="select-container">
        
        <select name="sort" class="select-box"id="sort">
            <option value="">Select an Option</option>
            <option value="low-to-high">Low to High</option>
            <option value="high-to-low">High to Low</option>
            <option value="trending">Trending</option>
        </select>
        <label for="sort" class="select-label">Sort By  </label>
    </div>
    <% 
    	List<Product> productList=dfFetcher.fetchProductsInfo();
    %>
    <div class="container">
    
    <% for(Product product:productList) {%>
        <div class="container-grid">

            <img class="product-image" src="images\products\<%=product.getPhoto() %>" alt="<%=product.getPhoto() %>">
                <div class="product-summary">

                    <a id="wishlist-btn" href="wishlist.jsp"><img class="wishlist-img js-wishlist-button" src="images\wishlist.png" alt=""></a>
                    <p   class="product-title"><pre  ><%= product.getTitle() %></pre>
                        <%= product.getDesc() %>
                    </p>
                    <div class="product-price">
                        <p id="price">&#8377; <%=product.getPrice() %></p>
                    </div>
                    <div class="action">
                        <a href="add-to-cart?pid=<%=product.getId() %>" class="add-cart-btn"  data-product-id="<%=product.getId() %>">Add to Cart</a>      
                </div>
            </div>

        </div>
       <%} %>
    </div>
  

</body>
</html>