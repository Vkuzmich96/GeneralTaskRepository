<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.07.2019
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>welcome</h1>
    <d:translation/>
    <span style="float: right">
    <a href="?lang=en_US">en</a>
    |
    <a href="?lang=ru_RU">ru</a>
    </span>
    <form action="pages/registration.jsp" >
        <input type="submit" value="registration">
    </form>
    <form action="pages/enter.jsp" >
        <input type="submit" value="enter">
    </form>
</body>
</html>
