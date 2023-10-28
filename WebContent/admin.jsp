<%@page import="com.watchstore.dfHandler.*" %>
<%@page import="java.util.*" %>
 <%@page  import="com.watchstore.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@page  import="com.watchstore.model.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin </title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  

<style> 
body{
margin:25px;
}
</style>
</head>
<body>

<%@include file="includes/nav.jsp"%>
<%
if(auth!=null){
	if( !auth.getType().equals("admin")){
		response.sendRedirect("index.jsp");
	}
	
}
else{
	response.sendRedirect("login.jsp");
}

%>
<div class="container">
<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#add" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Add Products</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#product" type="button" role="tab" aria-controls="pills-profile" aria-selected="false">View Products</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#users" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">View Users</button>
  </li>
</ul>
</div>



<div class="tab-content" id="pills-tabContent">
 
 
  <div class="tab-pane fade show active" id="add" role="tabpanel" aria-labelledby="add-tab">
		<div class="container"><br>
			<form action="add-product" method="post" enctype="multipart/form-data">
			 
			  <div class="mb-3">
			    <label for="pname" class="form-label">Product Name</label>
			    <input type="text" class="form-control" name="pname" id="pname">
			  </div>
			  <div class="mb-3">
			    <label for="pdesc" class="form-label">Product Description</label>
			    <textarea type="text" class="form-control" name="pdesc" id="pdesc"></textarea>
			  </div>
			  <div class="mb-3">
			    <label for="bid" class="form-label">Brand ID</label>
			    <input type="text" class="form-control" name="bid" id="bid" >
			  </div>
			  <div class="mb-3">
			    <label for="bname" class="form-label">Brand </label>
			    <input type="file" class="form-control" name="bname" id="bname" >
			  </div>
			  <div class="mb-3">
			    <label for="pprice" class="form-label"> Price</label>
			    <input type="text" class="form-control" id="pprice" name="pprice">
			  </div>
			  <div class="mb-3">
			    <label for="discount" class="form-label">Discount</label>
			    <input type="text" class="form-control" id="discount" name="discount">
			  </div>
			  <div class="mb-3">
			    <label for="pimg" class="form-label">Product Image</label>
			    <input type="file" class="form-control" id="pimg" name="pimg"> 
			  </div>
			  <div class="mb-3">
			    <label for="ptype" class="form-label">Product Type</label>
			    <input type="text" class="form-control" id="ptype" name="ptype"> 
			  </div>
			  <div class="mb-3">
			    <label for="pstock" class="form-label">Quantity</label>
			    <input type="text" class="form-control" id="pstock" name="pstock"> 
			  </div>
			  <br>
			  <button type="submit" class="btn btn-primary">Add Product</button>
			</form>
		
		</div>
	</div>
	

	
 <div class="tab-pane fade" id="product" role="tabpanel" aria-labelledby="product-tab">
		<%
			List<Product> plist=dfFetcher.fetchProductsInfo();
			    		
		%>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Product Title</th>
	      <th scope="col">Product Description</th>
	      <th scope="col">Brand</th>
	      <th scope="col">Product Price</th>
	      <th scope="col">Quantity</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody><br>
	  <% for(Product product : plist){
	  
	  %>
	    <tr>
	      <td><%= product.getTitle() %></td>
	      <td><%=  product.getDesc() %></td>
	      <td><%=  product.getBrand().getName() %></td>
	      <td><%=  product.getPrice() %></td>
	      <td><%=  product.getStock() %></td>
	      
	      <td>
	      
	      	<a href="delete?pid=<%= product.getId() %>">DELETE</a>
	      	
	      
		  </td>
	    </tr>
	  <% } %>
	  </tbody>
	</table>

</div>

  <div class="tab-pane fade" id="users" role="tabpanel" aria-labelledby="users-tab">
	
	

		<%
			List<User> usersList=dfFetcher.fetchUserInfo();
		%>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">User name</th>
	      <th scope="col">E-mail</th>
	      <th scope="col">Gender</th>
	      <th scope="col">Address</th>
	    </tr>
	  </thead>
	  <tbody>
	  <% for(User user : usersList){
		  if(!user.getType().equals("admin")){
	  
	  %>
	    <tr>
	      <td><%= user.getUname() %></td>
	      <td><%= user.getEmail() %></td>
	      <td><%= user.getGender() %></td>
	      <td><%= user.getPhoto()%></td>
	    </tr>
	  <% }} %>
	  </tbody>
	</table>
</div>

</div>


</body>
</html>