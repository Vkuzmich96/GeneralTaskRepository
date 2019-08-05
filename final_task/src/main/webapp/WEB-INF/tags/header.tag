<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag language="java" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="../../support/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <p> ${login} </p>
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a href="/logout.html" class="nav-link">logout</a>
                        </li>
                        <li class="nav-item active">
                            <a href="/profile.html" class="nav-link">profile</a>
                        </li>
                        <li class="nav-item active">
                            <a href="/pages/list.html" class="nav-link">general page</a>
                        </li>
                        <c:set var="lawerRoleNumber" value="2"/>
                        <c:if test="${lawerRoleNumber==role.getNumber()}">
                            <li class="nav-item active">
                                <a href="/lawyerMenu.html" class="nav-link">map constructor</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
</body>
