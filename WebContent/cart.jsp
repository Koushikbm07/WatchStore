<%@page import="com.watchstore.math.Calculate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.watchstore.model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
 <link rel="stylesheet" href="styles/cart.css">
</head>
<body style="padding-top:120px;padding-bottom:70px;">



<%@include file="includes/nav.jsp"%>
<%
ArrayList<Cart> cartList=(ArrayList<Cart>)request.getSession().getAttribute("cart-list");
List<Cart> carts=cartList;
int totalCart=Calculate.getTotalCart(carts) ;
int totalMRP=Calculate.getTotalCartMRP(carts);
int totalDisclount=Calculate.getTotalCartDiscount(carts);

%>

<strong id="my-cart">My Cart Products ( <%=carts.size() %> ) </strong>
    <div class="cart-container">
        <div class="cart-products">
        <% for(Cart cart : carts){ 
        %>
            <div class="cart-product">
                <div class="top">
                    <div class="product-image">
                        <img src="images\products\<%=cart.getPhoto() %>" alt="">
                    </div>
                    <div class="product-summary">
                    	<p class="product-title"><%=cart.getTitle() %></p>
                        <p class="description"><%=cart.getDesc() %></p>
                        <p class="price"><%=cart.getPrice()*cart.getQuantity() %></p>
                         <div class="quanti">
                            <a class="btn-dec" href="q-inc-dec?action=dec&pid=">
                                <i class="fas fa-minus-square"></i>
                            </a>
                            <input style="width:50px;margin:0 10px;"  type="text" name="quantity" value="<%=cart.getQuantity() %>" readonly>
                            <a style="margin-left:0;" class="btn-incre" href="q-inc-dec?action=inc&pid=">
                                <i class="fas fa-plus-square"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="bottom">
                    <a class="action" id="remove" href="remove-cart?pid=<%=cart.getId() %>">Remove</a>
                     <a class="action" id="wishlist"  href="wishlist?pic=<%=cart.getId() %>">Wishlist</a>
                </div>
            </div>
            <%} %>
        </div>
        <div class="cart-summary">
            <strong>SUMMARY</strong>
            <div class="order-summary">
                <p class="left">MRP</p>
                <p class="right"> &#8377; <%= totalMRP %></p>
                <p class="left">Discount</p>
                <p class="right"> &#8377; <%= totalDisclount%></p>
                <p class="left">Delivery</p>
                <p class="right">&#8377; ${(totalCart>500)?0:totalCart}</p>
                <p class="left">Total</p>
                <p class="right"> &#8377; <%=totalCart%></p>
            </div>
                <a id="place-order" class="action" href="">Place Order</a>          
             
            
        </div>
    </div>

</body>
</html>