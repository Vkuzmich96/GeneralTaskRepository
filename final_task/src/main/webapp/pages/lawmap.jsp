<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.07.2019
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="tp"%>
<html>
<head>
    <title>LawMap</title>
    <link href="../support/lawmap_style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <tp:printer graph="${graph}"/>
</body>
</html>
