
<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.userportal.model.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>
    <link rel="stylesheet" href="CSS/styleProfile.css">
    <script src="https://kit.fontawesome.com/e7516258f9.js" crossorigin="anonymous"></script>
</head>
<body>
	

    <ul>
      <li class="dropdown">
      <a href="javascript:void(0)"><i class="fas fa-sort-down"></i></a>
      <div class="container">
         <a href="changePassword.jsp">Change Password</a>
         <a href="login.jsp">Log Out</a>
      </div>
      </li>
      <li><h3><%=User.getFirstName() %>&nbsp<%=User.getLastName() %></h3></li>
    </ul>
    <div class="left">
        <a href="profile.jsp">Profile Page</a>
        <a href="changePassword.jsp">Change Password</a>
    </div>
    <div class="right">
        <div class="head_line">
            <h2>User Profile</h2>
        </div>
        
        <div class="main_pofile"> 
        
            <label>First Name &nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getFirstName()%></label><br><br>
            <label>Last Name &nbsp;&nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getLastName() %></label><br><br>
            <label>Address &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getAddress()%></label><br><br>
            <label>Phone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getPhone()%></label><br><br>
            <label>Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getEmail()%></label><br><br>
            <label>Birthdate &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
            <label><%=User.getBirthDate()%></label>
           
        </div>
    </div>
    <div class="clear"></div>
    <div class="footer"></div>
</body>
</html>