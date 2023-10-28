<%@page import="com.watchstore.math.Calculate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.watchstore.model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My WishList</title>
 <link rel="stylesheet" href="styles/cart.css">
 <style type="text/css">
 .action{

	text-decoration: none;
 }
 </style>
</head>
<body style="padding-top:120px;padding-bottom:70px;">



<%@include file="includes/nav.jsp"%>
<%
ArrayList<Product> wishList=(ArrayList<Product>)request.getSession().getAttribute("wishlist");
List<Product> wishLists=wishList;
%>

<% if(wishLists!=null && wishLists.size()>=1){ %>
<strong id="my-cart">My WishList ( <%=wishLists.size() %> ) </strong>
    <div class="cart-container">
        <div class="cart-products">
        <% for(Product product : wishLists){ 
        %>
            <div class="cart-product">
                <div class="top">
                    <div class="product-image">
                        <img src="images\products\<%=product.getPhoto() %>" alt="">
                    </div>
                    <div class="product-summary">
                    	<p class="product-title"><%=product.getTitle() %></p>
                        <p class="description"><%= product.getDesc()%></p>
                        <p class="price">&#8377;  <%=product.getPrice() %></p>
                         
                    </div>
                </div>

                <div class="bottom">
                    <a class="action" id="remove" href="remove-cart?pid=<%=product.getId() %>">Remove</a>
                    <% if(auth!=null) {%>
                     <a class="action" id="wishlist"  href="add-to-cart?pid=<%=product.getId() %>">Add To Cart</a>
                	<%} %>
                </div>
            </div>
            <%} %>
        </div>
        
    </div>
<%} else{ %>
<div style="width:100%;display:flex;justify-content:center;align-items:center;flex-direction:column;" class="nocart">
<div >
<img style="align-items:center;" alt="Empty-cart" src="images/cart/empty_cart.png">
</div>
<strong>Your WishList is Empty!</strong>
<br>
<a class="action" href="watches.jsp">Start Shopping</a>
</div>
<%} %>
</body>
</html>