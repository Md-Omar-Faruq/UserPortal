<%@ page import="java.util.*,com.userportal.model.*" %>
<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <link rel="stylesheet" href="CSS/styleChangePass.css">
    <script src="https://kit.fontawesome.com/e7516258f9.js" crossorigin="anonymous"></script>
</head>
<body>
    <ul>
      <li class="dropdown">
      <a href="javascript:void(0)"><i class="fas fa-sort-down"></i></a>
      <div class="container">
         <a href="profile.jsp">User Profile</a>
         <a href="login.jsp">Log Out</a>
      </div>
      </li>
      <li><h3><%=User.getFirstName()%>&nbsp<%=User.getLastName() %></h3></li>
    </ul>
    <div class="left">
        <a href="profile.jsp">Profile Page</a>
        <a href="changePassword.jsp">Change Password</a>
    </div>
    <div class="right">
        <div class="head_line">
            <h2>Change Password</h2>
        </div>
        <div class="main_pass">
            <form action="passChange" method="post">
                <label for="pre">Previous password &nbsp;&nbsp;&nbsp;: </label>
                <input type="password" name="previouspass" id="pre"><br><br>
                
                <label for="new">New Password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
                <input type="password" name="newpass" id="new"><br><br>
                
                <label for="confirm">Confirm Password &nbsp;&nbsp;&nbsp;:</label>
                <input type="password" name="conpass" id="confirm"><br><br>

                <input class="btn clr" type="reset" value="Clear">
                <input class="btn chng" type="submit" value="Change Password">
            </form>
        </div>
    </div>
    <div class="clear"></div>
    <div class="footer"></div>
</body>
</html>