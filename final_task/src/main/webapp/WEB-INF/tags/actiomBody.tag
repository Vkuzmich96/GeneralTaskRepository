<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
    <fmt:setBundle basename="label"/>
    <input hidden value="${actionId}" name="actionId">
    <label class="text-left"><fmt:message key="action"/></label>
    <input class="form-control" type="text" value="${name}" placeholder="<fmt:message key="enter.action.name"/>" name="name">
    <textarea class="form-control" type="text" rows="4" placeholder="<fmt:message key="enter.instructions"/>" name="instructions">${instructions}</textarea>
    <label class="text-left"><fmt:message key="material"/></label>
    <input class="form-control" type="text" value="${materialName}" placeholder="<fmt:message key="enter.material.name"/>" name="materialName">
    <textarea class="form-control" type="text" rows="4" placeholder="<fmt:message key="enter.description"/>" name="description">${description}</textarea>
</body>
</html>
