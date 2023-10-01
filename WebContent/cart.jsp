<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
 <link rel="stylesheet" href="styles/cart.css">
</head>
<body style="padding-top:120px;padding-bottom:70px;">



<%@include file="includes/nav.jsp"%>

<strong id="my-cart">My Cart Products</strong>
    <div class="cart-container">
        <div class="cart-products">
            <div class="cart-product">
                <div class="top">
                    <div class="product-image">
                        <img src="images\products\TitanSmart2.webp" alt="">
                    </div>
                    <div class="product-summary">
                    	<p class="product-title">Titan smart</p>
                        <p class="description">Just cavalli Women Snake Oval Green Watches</p>
                        <p class="price">9256</p>
                         <div class="quanti">
                            <a class="btn-dec" href="q-inc-dec?action=dec&pid=">
                                <i class="fas fa-minus-square"></i>
                            </a>
                            <input style="width:50px;margin:0 10px;"  type="text" name="quantity" value="" readonly>
                            <a style="margin-left:0;" class="btn-incre" href="q-inc-dec?action=inc&pid=">
                                <i class="fas fa-plus-square"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="bottom">
                    <a class="action" id="remove" href="">Remove</a>
                     <a class="action" id="remove"  href="">Wishlist</a>
                </div>
            </div>
            <div class="cart-product">
                <div class="top">
                    <div class="product-image">
                        <img src="images\products\TitanSmart2.webp" alt="">
                    </div>
                    <div class="product-summary">
                    	<p class="product-title">Titan smart</p>
                        <p class="description">Just cavalli Women Snake Oval Green Watches</p>
                        <p class="price">9256</p>
                         <div class="quanti">
                            <a class="btn-dec" href="q-inc-dec?action=dec&pid=">
                                <i class="fas fa-minus-square"></i>
                            </a>
                            <input style="width:50px;margin:0 10px;"  type="text" name="quantity" value="" readonly>
                            <a style="margin-left:0;" class="btn-incre" href="q-inc-dec?action=inc&pid=">
                                <i class="fas fa-plus-square"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="bottom">
                    <a class="action" id="remove" href="">Remove</a>
                     <a class="action" id="remove"  href="">Wishlist</a>
                </div>
            </div>
        </div>
        <div class="cart-summary">
            <strong>SUMMARY</strong>
            <div class="order-summary">
                <p class="left">MRP</p>
                <p class="right">Price</p>
                <p class="left">Discount</p>
                <p class="right">Price</p>
                <p class="left">Delivery</p>
                <p class="right">Price</p>
                <p class="left">Total</p>
                <p class="right">Price</p>
            </div>
                <a id="place-order" class="action" href="">Place Order</a>          
             
            
        </div>
    </div>

</body>
</html>