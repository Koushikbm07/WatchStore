<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
<link rel="stylesheet" href="styles/forms.css">
</head>
<body>


<%@include file="includes/nav.jsp"%>


<form action="RegisterServlet" method="post">
        <div style="height: 80vh;" class="container">
            <div class="container-top">
                <img src="images/nav/logo.png" alt="watchstore">
                <p>Welcome to WatchStore</p>
               
            </div>
            
            <label for="email">Email</label>
            <input placeholder="koushik@gmail.com" type="email" name="email" id="email" for="email" required>
            <label for="password">Password</label>
            <input placeholder="Enter Password" type="password" name="password" id="password" for="password" required>
            <label for="password">Confirm Password</label>
            <input placeholder="Enter Confirm Password" type="password" name="password" id="password" for="password" required>
   
            <label for="usertype">I am a</label>
            <select name="usertype" id="usertype">
                <option value="user">USER</option>
                <option value="admin">ADMIN</option>
            </select>
            <label for="gender">Gender</label>
            <select name="gender" id="gender">
                <option value="user">Male</option>
                <option value="admin">Female</option>
            </select>
            
            <button type="submit"> Register</button>
            
            <a href="login.jsp">Already User? 
            </a>
        </div>
        
    </form>

</body>
</html>