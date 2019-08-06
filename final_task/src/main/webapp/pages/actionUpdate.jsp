<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.08.2019
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>Update Action</title>
</head>
<body>
    <u:header/>
    <div class="container">
        <form action="/updateAction.html" method="post">
            <div class="form-group text-center">
                <u:actiomBody/>
                <div class="text-left">
                    <input type="submit" value="update">
                </div>
            </div>
        </form>
    </div>
</body>
</html>
