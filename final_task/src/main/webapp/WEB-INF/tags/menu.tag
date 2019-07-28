<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag language="java" pageEncoding="UTF-8"%>

<div>
    <p> ${login} </p>
    <form action="/logout.html" method="post">
        <input type="submit" value="logout">
    </form>
    <form action="/update.html" method="post">
        <input type="submit" value="update profile">
    </form>
    <c:set var="role" value="${role}"/>
    <c:set var="lawerRoleNumber" value="2"/>
    <c:if test="${lawerRoleNumber==role.getNumber()}">
        <form action="/lawermenu.html">
            <input type="submit" value="lawer menu">
        </form>
    </c:if>
</div>
