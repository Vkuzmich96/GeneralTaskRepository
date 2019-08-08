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
<c:set var="gaphId" value="${graph_id}"/>
<c:if test="${null == gaphId}">
<div class="container">
    <form action="/addMap.html" method="post">
        <div class="form-group text-center">
            <p class="text-left">Create map</p>
            <input class="form-control" type="text" placeholder="enter map name" name="name"/>
            <div class="text-left">
                <input type="submit" value="create"/>
            </div>
        </div>
    </form>
</div>
</c:if>

<c:if test="${null != gaphId}">
    <div class="container">
    <form action="/addAction.html" method="post" enctype="multipart/form-data">
        <div class="form-group text-center">
            <u:actiomBody/>
            <div class="text-left">
                <input type="file" name="file">
                <input type="submit" value="add"/>
                <input type="checkbox" name="isNext"> next step
                <a href="/realise.html?number=${graph_id}"> realise map </a>
                <a href="/delete.html?number=${graph_id}"> delete map </a>
            </div>
        </div>
    </form>
    <d:graph number="${graph_id}"/>
    </div>
</c:if>
</body>
</html>
