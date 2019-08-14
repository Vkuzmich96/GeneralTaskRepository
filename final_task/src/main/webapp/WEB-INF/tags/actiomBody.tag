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
    <c:if test="${empty action}">
            <c:set var="name" value="${param.get('name')}"/>
            <c:set var="instructions" value="${param.get('instructions')}"/>
            <c:set var="materialName" value="${param.get('materialName')}"/>
            <c:set var="description" value="${param.get('description')}"/>
    </c:if>
    <fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
    <fmt:setBundle basename="label"/>
    <input hidden value="${actionId}" name="actionId">
    <label class="text-left"><fmt:message key="action"/></label>
    <c:set var="wrongNameMessage"  value="${param.get('wrongName')}"/>
    <c:if test="${wrongNameMessage ne null}">
        <p class="text-center text-danger"><fmt:message key="${wrongNameMessage}"/></p>
    </c:if>
    <input class="form-control" type="text" value="${name}" placeholder="<fmt:message key="enter.action.name"/>" name="name">
    <c:set var="wrongInstructionMessage"  value="${param.get('wrongInstruction')}"/>
    <c:if test="${wrongInstructionMessage ne null}">
        <p class="text-center text-danger"><fmt:message key="${wrongInstructionMessage}"/></p>
    </c:if>
    <textarea class="form-control" type="text" rows="4" placeholder="<fmt:message key="enter.instructions"/>" name="instructions">${instructions}</textarea>
    <label class="text-left"><fmt:message key="material"/></label>
    <c:set var="wrongMaterialNameMessage"  value="${param.get('wrongMaterialName')}"/>
    <c:if test="${wrongMaterialNameMessage ne null}">
        <p class="text-center text-danger"><fmt:message key="${wrongMaterialNameMessage}"/></p>
    </c:if>
    <input class="form-control" type="text" value="${materialName}" placeholder="<fmt:message key="enter.material.name"/>" name="materialName">
    <c:set var="wrongDescriptionNameMessage"  value="${param.get('wrongDescriptionName')}"/>
    <c:if test="${wrongDescriptionNameMessage ne null}">
        <p class="text-center text-danger"><fmt:message key="${wrongDescriptionNameMessage}"/></p>
    </c:if>
    <textarea class="form-control" type="text" rows="4" placeholder="<fmt:message key="enter.description"/>" name="description">${description}</textarea>
</body>
</html>
