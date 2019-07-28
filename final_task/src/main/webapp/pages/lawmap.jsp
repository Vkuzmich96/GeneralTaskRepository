<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.07.2019
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>LawMap</title>
</head>
<body>
    <u:menu/>
    <d:graph number="${number}"/>
</body>
</html>
