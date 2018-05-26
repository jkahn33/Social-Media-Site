<%@ page import="main.java.com.jkahn.social.objects.Status" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.com.jkahn.social.objects.HomepageData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE  html>
<html>
<head>
    <title>Home</title>
    <% HomepageData theData = (HomepageData) request.getAttribute("data"); %>
</head>
<body>
<h1>Welcome ${data.user.first} ${data.user.last}!</h1>
<form action="/user/writeStatus" method="POST">
    <input type="text" name="text"><button type="submit">Submit</button>
</form>
<%for(Status s : theData.getStatuses()){ %>
<%=s.getText()%>
<%%>

<form action="/user/checkFriends" method="GET">
    <button type="submit">Test</button>
</form>
</body>
</html>
