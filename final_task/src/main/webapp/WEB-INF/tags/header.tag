<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag language="java" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../../support/css/util.css">
    <link rel="stylesheet" type="text/css" href="../../support/css/main.css">
    <link rel="stylesheet" type="text/css" href="../../support/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
            <fmt:setBundle basename="label"/>
            <c:set var="pageUri" value="${pageContext.request.requestURI}"/>
            <c:set var="redirectUrl" value="/pages/list.html"/>
            <div class="container-fluid">
                <p> ${login} </p>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav ml-auto">
                        <c:if test="${pageUri eq '/pages/list.jsp'}">
                            <li class="nav-item active">
                                <a href="/setLocale.html?locale=en&url=${redirectUrl}" class="nav-link">EN</a>
                            </li>
                            <li class="nav-item active">
                                <a href="/setLocale.html?locale=ru&url=${redirectUrl}" class="nav-link">RU</a>
                            </li>
                        </c:if>
                        <li class="nav-item active">
                            <a href="/logout.html" class="nav-link"><fmt:message key="logout"/></a>
                        </li>
                        <li class="nav-item active">
                            <a href="/profile.html" class="nav-link"><fmt:message key="profile"/></a>
                        </li>
                        <li class="nav-item active">
                            <a href="/pages/list.html" class="nav-link"><fmt:message key="general.page"/></a>
                        </li>
                        <c:set var="lawerRoleNumber" value="2"/>
                        <c:if test="${lawerRoleNumber==role.getNumber()}">
                            <li class="nav-item active">
                                <a href="/lawyerMenu.html" class="nav-link"><fmt:message key="map.constructor"/></a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
</body>
