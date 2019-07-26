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
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>NamesList</title>
</head>
<body>
    <div>
        <h4>You may work</h4>
        <u:menu/>
        <p>Law map list</p>
        <c:forEach var="map" items="${maps}">
            <li>
                 <span>
                        <a href = /lawmap.html?number=${map.getId()}> ${map.getName()} </a>
                 </span>
            </li>
        </c:forEach>
    </div>
</body>
</html>
