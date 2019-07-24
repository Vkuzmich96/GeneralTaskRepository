<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.07.2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>

<html>
<head>
    <title>NamesList</title>
</head>
<body>
    <h1>You may work</h1>
    <d:menu/>
    <d:nameList names="${maps}"/>
</body>
</html>
