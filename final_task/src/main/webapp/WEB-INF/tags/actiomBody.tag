<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.08.2019
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@tag language="java" pageEncoding="UTF-8"%>
<html>
<body>
    <c:if test="${not empty action}">
        <c:set var="actionId" value="${action.getId()}"/>
        <c:set var="name" value="${action.getName()}"/>
        <c:set var="instructions" value="${action.getInstructions()}"/>
        <c:set var="material" value="${action.getMaterials().get(0)}"/>
        <c:set var="materialName" value="${material.getName()}"/>
        <c:set var="description" value="${material.getDiscription()}"/>
    </c:if>
    <input hidden value="${actionId}" name="actionId">
    <label class="text-left">Action</label>
    <input class="form-control" type="text"  value="${name}" placeholder="enter action name" name="name">
    <textarea class="form-control" type="text" rows="4" placeholder="enter instructions" name="instructions">${instructions}</textarea>
    <label class="text-left">Material</label>
    <input class="form-control" type="text" value="${materialName}" placeholder="enter material name" name="materialName">
    <textarea class="form-control" type="text" rows="4" placeholder="enter description" name="description">${description}</textarea>
</body>
</html>
