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
<base href="<%=request.getContextPath()%>/">

<link rel="stylesheet" type="text/css" href="styles/watches.css">
</head>
<body>


<%@include file="includes/nav.jsp"%>

    <% 
    	List<Product> productList=(List<Product>) request.getAttribute("productsByBrandId");
    %>
    <div class="container">
    
    <% if(productList!=null){
    for(Product product:productList) {%>
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
       <%}} %>
    </div>
  

</body>
</html>