<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Response Page</title>
</head>
<body>
    <c:forEach items="${list}" var="candy">
        <p>${candy}</p>
    </c:forEach>
</body>
</html>