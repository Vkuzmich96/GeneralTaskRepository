<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.07.2019
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter</title>
</head>
<body>
    <form action="/enter.html" method="post">
        <label>
            <p>${massage}</p>
            <input type="text" placeholder="email" name="email">
            <p/>
            <input type="text" placeholder="password" name="password">
            <p/>
            <input type="submit" value="enter">
        </label>
    </form>
</body>
</html>
