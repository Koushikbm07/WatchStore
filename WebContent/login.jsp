<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
  <link rel="stylesheet" href="styles/forms.css">
</head>
<body style="padding-top:100px;">

<%@include file="includes/nav.jsp"%>


<form action="login" method="post">
        <div class="container">
            <div class="container-top">
                <img src="images/nav/logo.png" alt="watchstore">
                <p>Welcome to WatchStore</p>
            </div>
            
            <label for="email">Email</label>
            <input placeholder="koushik@gmail.com" type="email" name="email" id="email" for="email">
            <label for="password">Password</label>
            <input placeholder="**********" type="password" name="password" id="password" for="password">
            <button type="submit"> Login </button>
            <a href="forgotpassword.jsp">Forget Password ?</a>
            <a href="register.jsp">New to WatchStore ? </a>
        </div>
        
</form>

</body>
</html>