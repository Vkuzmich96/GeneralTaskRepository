<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.07.2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>WorkPage</title>
</head>
<body>
    <h1>You may work</h1>
    <c:forEach items="${maps}" var="maps">
        <p>${maps}</p>
    </c:forEach>

    <form action="/lawmap.html" method="get">
        <input type="hidden" value="1" name="number">
        <input type="submit" value="send">
    </form>
</body>
</html>
