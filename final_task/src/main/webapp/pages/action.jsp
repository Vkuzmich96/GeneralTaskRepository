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
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Action</title>
</head>
<body>
    <u:header/>
    <fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
    <fmt:setBundle basename="label"/>
    <div>
        <h4> ${action.getName()} </h4>
        <c:set var="lawerRoleNumber" value="2"/>
        <c:if test="${lawerRoleNumber==role.getNumber()}">
            <a href="/updateActionMenu.html?number=${action.getId()}" class="btn btn-primary"> <fmt:message key="update"/> </a>
        </c:if>
        <p> ${action.getInstructions()} </p>
        <c:set var="prefix" value="/docs/"/>
        <c:forEach var="material" items="${action.getMaterials()}">
            <p>
                ${material.getName()} <a href="${prefix}${material.getUrl()}" class="btn btn-primary"> <fmt:message key="download"/> </a>
            </p>
            <p> ${material.getDiscription()} </p>
        </c:forEach>
    </div>
</body>
</html>
