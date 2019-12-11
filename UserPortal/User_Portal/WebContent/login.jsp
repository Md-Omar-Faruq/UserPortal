<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="CSS/styleLogin.css">
    <script src="https://kit.fontawesome.com/e7516258f9.js" crossorigin="anonymous"></script>
</head>
<body>

   <div class="main_box">
   
    <i class=" d-flex justify-content-center fas fa-address-book fa-3x"></i>
    <h3 class="login_h3">Login Panel</h3>
       <div class="inner_box">
       
            <form action="login_form" method="post">
                <label for="email" class="form-login-label">Email Address</label>
                <input class="form_data email-box" type="email" name="email" id="email" value="admin@localhost.local"><br><br>
                <label class="form-login-label" for="pass">Password</label>
                <input class="form_data pass-box" type="password" name="pass" id="pass"><br>
                <input class="form_btn" type="submit" value="Login">
                <input class="form_btn" type="reset" value="Clear"><br><br>
                <span style="display: block; text-align: center;">Are you new here??
                <a href="registration.html">Register Now</a></span>
            </form>
            
        </div>
    </div>
    
</body>
</html>