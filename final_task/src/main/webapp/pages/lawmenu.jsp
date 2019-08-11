<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>LawyerMenu</title>
</head>
<body>
<u:header/>
<c:if test="${empty graphId}">
    <div class="container">
        <form action="/addMap.html" method="post">
            <div class="form-group text-center">
                <p class="text-left">Create map</p>
                <input class="form-control" type="text" placeholder="enter map name" name="name"/>
                <div class="text-left">
                    <input type="submit" class="btn btn-primary" value="create"/>
                </div>
            </div>
        </form>
    </div>
</c:if>

<c:if test="${not empty graphId}">
    <div class="container">
        <form action="/addAction.html" method="post" enctype="multipart/form-data">
            <div>
                <c:out value="${step}"/>
                <c:if test="${empty step}">
                    <c:set var="step" value="${1}"/>
                </c:if>
                <c:out value="$$$$$$$$$"/>
                <c:out value="${graphId}"/>
                <c:out value="${step}"/>
                <c:out value="${actionId}"/>
                <c:out value="${actualActionId}"/>
                <input type="hidden" value="${graphId}" name="graphId">
                <input type="hidden" value="${step}" name="step">
                <input type="hidden" value="${actionId}" name="actionId">
                <input type="hidden" value="${actualActionId}" name="actualActionId">
            </div>
            <div class="form-group text-center">
                <u:actiomBody/>
                <div class="text-left">
                    <input type="file" name="file">
                    <input type="submit" class="btn btn-primary" value="add"/>
                    <input type="checkbox" name="isNext"> next step
                    <a href="/release.html?number=${graphId}" class="btn btn-primary"> release map </a>
                    <a href="/delete.html?number=${graphId}" class="btn btn-primary"> delete map </a>
                </div>
            </div>
        </form>
        <d:graph number="${graphId}"/>
    </div>
</c:if>
</body>
</html>
