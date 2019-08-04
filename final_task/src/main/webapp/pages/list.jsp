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
    <u:menu/>
    <div class="container">
        <div class="list-group text-center">
            <p class="list-group-item active">Law map list:</p>
                <c:set var="number" value="${0}"/>
                <c:forEach var="map" items="${maps}">
                    <c:set var="readiness" value="${map.getReadiness()}"/>
                    <c:if test="${(role.getNumber() == 2) || readiness}">
                         <c:set var="id" value="${map.getId()}"/>
                         <c:set var="name" value="${map.getName()}"/>
                        <span class="list-group-item list-group-item-action">
                                ${number = number + 1}
                                <a href = /lawmap.html?number=${id}> ${name} </a>
                                <c:if test="${!readiness}">
                                    <a href = /continue.html?number=${id}> continue work </a>
                                </c:if>
                         </span>
                    </c:if>
                </c:forEach>
        </div>
    </div>
</body>
</html>
