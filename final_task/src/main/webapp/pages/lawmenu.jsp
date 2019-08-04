<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>LawerMenu</title>
</head>
<body>
<c:set var="gaphId" value="${graph_id}"/>
<c:if test="${null == gaphId}">
    <form action="/addMap.html" method="post">
        <p>Create map</p>
        <input type="text" placeholder="enter map name" name="name"/>
        <p/>
        <input type="submit" value="create"/>
    </form>
</c:if>

<c:if test="${null != gaphId}">
    <form action="/addAction.html" method="post" enctype="multipart/form-data">
        <p>Add action</p>
        <input type="text" placeholder="enter action name" name="name">
        <p/>
        <input type="text" placeholder="enter instructions" name="instructions">
        <p>Add material</p>
        <input type="text" placeholder="enter material name" name="name">
        <p/>
        <input type="text" placeholder="enter description" name="description">
        <p/>
        <input type="file" name="file">
        <p/>
        <input type="submit" value="add"/>
        <input type="checkbox" name="isNext"> next step
    </form>
    <d:graph number="${graph_id}"/>
    <a href="/realise.html?number=${graph_id}"> realise map </a>
    <a href="/delete.html?number=${graph_id}"> delete map </a>
</c:if>
</body>
</html>
