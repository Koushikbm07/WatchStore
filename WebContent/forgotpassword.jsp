<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set New Password</title>
<link rel="stylesheet" href="styles/forms.css">
</head>
<body style="padding-top:100px;">

<%@include file="includes/nav.jsp"%>

<form action="ForgotServlet" method="post">
        <div class="container">
            
            <label for="email">Email</label>
            <input placeholder="koushik@gmail.com" type="email" name="email" id="email" for="email">
            <label for="password">New Password</label>
            <input placeholder="**********" type="password" name="password" id="password" for="password">
            <label for="password">Confirm Password</label>
            <input placeholder="**********" type="password" name="password" id="password" for="password">
            <button type="submit"> Login
            </button>
            <a href="login.jsp">Already User ?</a>
            <a href="register.jsp">New to WatchStore ? 
            </a>
        </div>
        
    </form>
</body>
</html>