<%--
  Created by IntelliJ IDEA.
  User: Jacob
  Date: 3/14/2018
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <spring:url value="/resources/css/bootstrap/bootstrap.css" var="bootstrap" />
  <spring:url value="/resources/css/pages/homepage.css" var="css"/>
  <link href="https://fonts.googleapis.com/css?family=Raleway:900" rel="stylesheet">
  <link href="${bootstrap}" rel="stylesheet"/>
  <link href="${css}" rel="stylesheet"/>
  <title>Social Media</title>
</head>
<body>
<h1 id="welcome" align="center">Welcome to Jacob's Social Media Site</h1>
<form id="submitLogin" action="/user/login" method="POST">
  <div class="form-group">
    <label for="uEmail" style="font-size:35px;">Email</label>
    <input type="email" class="form-control" id="uEmail" placeholder="Enter email"/>
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
<form id="signUp" action="/user/signup" method="GET">
  <button type="submit" class="btn btn-success">Sign up</button>
</form>
</body>
</html>