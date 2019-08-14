<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>LawyerMenu</title>
</head>
<body>
<u:header/>
<fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
<fmt:setBundle basename="label"/>
<c:if test="${param.get('graphId') eq null}">
    <c:set var="wrongNameMessge" value="${param.get('wrongName')}"/>
    <div class="container">
        <form action="<c:url value="/addMap.html"/>" method="post">
            <div class="form-group text-center">
                <c:if test="${wrongNameMessge ne null}">
                    <p class="text-center text-danger"><fmt:message key="${wrongNameMessge}"/></p>
                </c:if>
                <p class="text-left"><fmt:message key="create.map"/></p>
                <input class="form-control" type="text" value="${param.get('name')}" placeholder="<fmt:message key="name"/>" name="name" required minlength="4" maxlength="45" pattern="^[-а-яА-ЯёЁa-zA-Z ]{4,45}$"/>
                <div class="text-left">
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="create"/>"/>
                </div>
            </div>
        </form>
    </div>
</c:if>

<c:if test="${param.get('graphId') ne null}">
    <div class="container">
        <form action="<c:url value="/addAction.html"/>" method="post" enctype="multipart/form-data">
            <div>
                <c:set var="actionId" value="${param.get('actionId')}"/>
                <c:set var="actualActionId" value="${param.get('actualActionId')}"/>
                <input type="hidden" value="${param.get('graphId')}" name="graphId">
                <input type="hidden" value="${param.get('step')}" name="step">
                <input type="hidden" value="${actionId}" name="actionId">
                <input type="hidden" value="${actualActionId}" name="actualActionId">
            </div>
            <div class="form-group text-center">
                <u:actiomBody/>
                <c:set var="wrongFile" value="${param.get('impossibleToReade')}"/>
                <div class="text-left">
                    <c:if test="${wrongFile ne null}">
                        <p class="text-center text-danger"><fmt:message key="${wrongFile}"/></p>
                    </c:if>
                    <input type="file" name="file">
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="add"/>"/>
                    <c:choose>
                        <c:when test="${(actionId ne null) and ((actualActionId eq null) or (actualActionId eq ''))}">
                            <input hidden value="on" name="isNext">
                        </c:when>
                        <c:when test="${(actionId ne null) and ((actualActionId ne null) or (actualActionId ne ''))}">
                            <input type="checkbox" name="isNext"> <fmt:message key="next.step"/>
                        </c:when>
                    </c:choose>
                    <a href="<c:url value="/release.html?number=${param.get('graphId')}"/>" class="btn btn-primary"> <fmt:message key="release.map"/> </a>
                    <a href="<c:url value="/delete.html?number=${param.get('graphId')}"/>" class="btn btn-primary"> <fmt:message key="delete.map"/> </a>
                </div>
            </div>
        </form>
        <d:graph number="${param.get('graphId')}"/>
    </div>
</c:if>
</body>
</html>
