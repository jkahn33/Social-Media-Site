<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE  html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome ${user.first} ${user.last}!</h1>
<form action="/user/writeStatus" method="POST">
    <input type="text" name="text"><button type="submit">Submit</button>
</form>
</body>
</html>
