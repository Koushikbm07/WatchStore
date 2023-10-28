<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
<link rel="stylesheet" href="styles/account.css">
    <link rel="stylesheet" href="styles/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

</head>
<body>
<%@include file="includes/nav.jsp"%>

<% if(auth!=null){ %>
 
    <div class="popup" id="myForm" >
        <div id="close-form" onclick="closeForm()"><i class="fa-solid fa-x"></i></div>
        <form action="profile-update" method="post">
            <label for="name">Photo</label>
            <input type="file" name="name" value="Koushik">
            <label for="name">Name</label>
            <input type="text" name="name" value="Koushik">
            <label for="email">Email Address</label>
            <input type="email" name="email" value="kmalagannavar@gmail.com">
            
            <label for="phone">Phone Number</label>
            <input type="text" name="phone" value="8904839357">
            <label for="gender">Gender</label>
            <select name="gender" id="gender">
                <option value="user">Male</option>
                <option value="admin">Female</option>
            </select>
             <button onclick="closeForm()" type="button"> Save </button>
        </form>
    </div>
    <div class="popup" id="myAddress" >
        <div id="close-form" onclick="closeAddress()"><i class="fa-solid fa-x"></i></div>
        <form action="add-address" method="post">
            <label for="name">Street</label>
            <input type="text" name="name" value="Koushik">
            <label for="name">Address</label>
            <textarea rows="3" cols="50">
  Nava Ayodhya Nagar main road , near ghodke factory , Old Hubli , Hubli 
			</textarea>
            
            <label for="city">City</label>
            <input type="email" name="city" value="Hubli">
            
            <label for="state">State</label>
            <input type="text" name="state" value="karnataka">
            
            <label for="pincode">Pincode</label>
            <input type="text" name="pincode" value="580024">
            
            
             <button onclick="closeForm()" type="button"> Save </button>
        </form>
    </div>
    
    <div class="account-container">

        <div class="account">
         
            <img src="images\brands\<%=auth.getPhoto() %>" alt="User Photo">
            <div class="account-info">
                <strong><%= auth.getUname() %></strong>
            </div>
        </div>
        <div class="account-grid">
            <div class="grid-items">
                <a href="orders" id="order">
                    <div class="item">
                        <img src="images\account\orders_icon.png" alt="">
                    </div>
                    <p>Orders</p>
                    <span>Check your Orders Here</span>
                </a>

            </div>
            <div class="grid-items">
               
                <a onclick="openForm()"  href="#" id="profile">
                    <div class="item">
                        <img src="images\account\profile_icon.png" alt="">
                    </div>
                    <p>Profile</p>
                    <span>Modify your details Here</span>
                </a>
            </div>

        <div class="grid-items">
            <a href="wishlist.jsp" id="wishlist">
                <div class="item">
                    <img src="images\account\wishlist_icon_new.png" alt="">
                </div>
                <p>Wishlist</p>
                <span>Check your Wishlist Here</span>
            </a>

        </div>
        <div class="grid-items">
            <a onclick="openAddress()"  href="#" id="address">
                <div class="item">
                    <img src="images\account\address_icon.png" alt="">
                </div>
                <p>Address</p>
                <span>Change Your Address</span>
            </a>

        </div>

    </div>
    </div>

   
    <button id="logout" >
    <a style="text-decoration: none;color:white;" href="logout">Logout</a>
    </button>
   
<%} %>
</body>
<script>
    function openForm() {
        document.getElementById("myForm").style.display = "block";
        
        document.getElementById("myForm").style.top = "20%";
      }
      
      function closeForm() {
        document.getElementById("myForm").style.display = "none";
      }
    function openAddress() {
        document.getElementById("myAddress").style.display = "block";
        
        document.getElementById("myAddress").style.top = "20%";
      }
      
      function closeAddress() {
        document.getElementById("myAddress").style.display = "none";
      }
</script>

</body>
</html>