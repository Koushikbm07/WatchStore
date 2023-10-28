<head>

<meta name="viewport" charset="ISO-8859-1" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="styles/nav.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" >
</head>
<%@page import="com.watchstore.model.*" %>
<%
User auth=(User) request.getSession().getAttribute("auth");

%>
    <div class="header">
        <a href="index.jsp"><img class="logo" src="images/nav/logo.png" alt=""></a>
        <div class="header-options">
            <a class="item" href="watches.jsp">Watches</a>
            <a class="item" href="brands.jsp">Brands</a>
            <a class="item" href="men.jsp">Men</a>
            <a class="item" href="women.jsp">Women</a>
            <input type="search" placeholder="Search products, brands...">
        </div>
        <div class="header-icons">
        
        <% if(auth==null) {%>
            <a class="item" href="login.jsp">Login</a>
               <%} else { %> 
              <% if(auth.getType().equals("admin")){ %>
              <a class="item" href="admin.jsp">${ auth.getUname()}</a> 
              <% } else {%>
                <a class="item" href="#">${ auth.getUname()}</a> 
            <%} %>
            <a class="item" href="wishlist.jsp"><img src="images/nav/wishlist.png" alt=""></a>
     		 <a class="item" href="account.jsp"><i class="fa-regular fa-user"></i></a>
         
         <%} %>
         <a class="item" href="cart.jsp"> <i class="fa-solid fa-cart-shopping"></i></a>
        </div>
    </div>

    <footer class="footer">
        <div class="footer-icons">
            <a href="index.jsp"><img src="images/footer/home.png" alt=""></a>
            <a href="men.jsp"><img src="images/footer/men.png" alt=""></a>
            <a href="brands.jsp"><img src="images/footer/brands.png" alt=""></a>
            <a href="women.jsp"><img src="images/footer/women.png" alt=""></a>
            <a href="account.jsp"><img src="images/footer/account.png" alt=""></a>
        </div>
    </footer>
