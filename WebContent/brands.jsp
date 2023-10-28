<%@page import="com.watchstore.dfHandler.dfFetcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.watchstore.model.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Brands</title>
<link rel="stylesheet" href="styles/brands.css">
</head>
<body>


<%@include file="includes/nav.jsp"%>

<div class="headlines">
        <p>Partnered Brands</p>
    </div>
    <% List<Brand> brands=dfFetcher.fetchBrandInfo();
   
    %>
    <div class="brands-container">
    <%for(Brand brand : brands){ %>
        <div class="brand">
        <a href="brand/<%= brand.getName()%>?bid=<%=brand.getBid()%>">
            <img src="images\brands\<%=brand.getPhoto()%>" alt="">        
        </a>
        </div>
       <%} %> 
    </div>

</body>
</html>