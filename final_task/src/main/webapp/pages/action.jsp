<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.07.2019
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Action</title>
</head>
<body>
    <div>
        <h4> ${action.getName()} </h4>
        <p> ${action.getInstructions()} </p>
        <c:set var="prefix" value="/doks/"/>
        <c:forEach var="material" items="${action.getMaterials()}">
            <p> ${material.getDiscription()} </p>
            <p>
                ${material.getName()} <a href = ${prefix}${material.getUrl()}> download </a>
            </p>
        </c:forEach>
    </div>
</body>
</html>
