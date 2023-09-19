<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/nav.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

</head>
<body>



    <div class="header">
        <a href="index.jsp"><img class="logo" src="images/nav/logo.png" alt=""></a>
        <div class="header-options">
            <a href="watches.jsp">Watches</a>
            <a href="brands.jsp">Brands</a>
            <a href="men.jsp">Men</a>
            <a href="women.jsp">Women</a>
            <input type="search" placeholder="Search products, brands...">
        </div>
        <div class="header-icons">
            <a href="login.jsp">Login</a>
            <a href="wishlist.jsp"><img src="images/nav/wishlist.png" alt=""></a>
            <a href="myaccount.jsp"><i class="fa-regular fa-user"></i></a>
            <a href="cart.jsp"> <i class="fa-solid fa-cart-shopping"></i></a>


        </div>
    </div>

    <footer class="footer">
        <div class="footer-icons">

            <a href="index.jsp"><img src="images\footer\home.png" alt=""></a>
            <a href="men.jsp"><img src="images\footer\men.png" alt=""></a>
            <a href="brands.jsp"><img src="images\footer\brands.png" alt=""></a>
            <a href="women.jsp"><img src="images\footer\women.png" alt=""></a>
            <a href="myaccount.jsp"><img src="images\footer\account.png" alt=""></a>
        </div>
    </footer>

</body>
</html>