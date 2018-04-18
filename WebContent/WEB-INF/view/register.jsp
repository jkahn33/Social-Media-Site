<%@ page import="main.java.com.jkahn.social.objects.RegisterCheck" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <spring:url value="/resources/css/bootstrap/bootstrap.css" var="bootstrap" />
    <spring:url value="/resources/css/pages/signup.css" var="css"/>
    <spring:url value="/resources/js/preLog.js" var="js" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Raleway:900" rel="stylesheet">
    <link href="${bootstrap}" rel="stylesheet"/>
    <link href="${css}" rel="stylesheet"/>
    <script src="${js}"></script>

    <title>Sign up</title>
</head>
<body>
<% RegisterCheck check = (RegisterCheck) request.getAttribute("check"); %>
<% if(check.getCheck()){ %>
<h1 align="center" id="registerHeader">Register new user</h1>
<form action="/user/registerUser" method="POST" align="center" style="margin-left:75px; margin-right:75px;" id="submitSignup">
    <div align="center" style="color:#ffffff;" class="form-group">
        First name <input style=" width:335px;" type="text" class="form-control" name="firstName" id="tFirst" placeholder="Enter first name"/>
    </div>
    <div align="center" style="color:#ffffff;" class="form-group">
        Last name <input style=" width:335px;" type="text" class="form-control" name="lastName" id="tLast" placeholder="Enter last name"/>
    </div>
    <div align="center" style="color:#ffffff;" class="form-group">
        Email <input style=" width:335px;" type="email" class="form-control" name="email" id="tEmail" placeholder="Enter email"/>
    </div>
    <button type="submit" class="btn btn-success">Register!</button>
</form>
<% } else { %>
<form action="/user/registerUser" method="POST" align="center" style="margin-left:75px; margin-right:75px;" id="submitSignup">
    <div align="center" style="color:#ffffff;" class="form-group">
        First name <input style=" width:335px;" type="text" class="form-control" name="firstName" id="fFirst" placeholder="Enter first name"/>
    </div>
    <div align="center" style="color:#ffffff;" class="form-group">
        Last name <input style=" width:335px;" type="text" class="form-control" name="lastName" id="fLast" placeholder="Enter last name"/>
    </div>
    <div align="center" style="color:#ffffff;" class="form-group">
        Email <input style=" width:335px;" type="email" class="form-control" name="email" id="fEmail" placeholder="Enter email"/>
        <div class="alert alert-danger" role="alert">
            <strong>That email already has an account.</strong> Please enter a new email.
        </div>
    </div>
    <button type="submit" class="btn btn-success">Register!</button>
</form>
<% } %>
</body>
</html>