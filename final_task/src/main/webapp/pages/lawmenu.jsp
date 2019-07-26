<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>LawerMenu</title>
</head>
<body>
    <u:step/>
    <c:set var="gaphId" value="${graph_id}"/>
    <c:if test="${null != gaphId}">
        <form action="/addMap" method="post">
            <p>Add map</p>
            <input type="text" placeholder="enter map name" name="name"/>
            <p/>
            <input type="submit" value="add"/>
        </form>
    </c:if>
    <form action="/addAction.html" method="post">
        <p>Add action</p>
        <input type="text" placeholder="enter action name" name="name">
        <p/>
        <input type="text" placeholder="enter description" name="description">
        <p/>
        <input type="submit" value="add"/>
    </form>
    <form action="/addMaterial.html" method="post">
        <p>Add material</p>
        <input type="text" placeholder="enter material name" name="name">
        <p/>
        <input type="text" placeholder="enter description" name="description">
        <p/>
        <input type="file" name="file">
        <p/>
        <input type="submit" value="add"/>
    </form>
</body>
</html>
