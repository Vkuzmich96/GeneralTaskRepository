<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <c:set var="role" value="${role}"/>
    <c:set var="adminRoleNumber" value="1"/>
    <div>
        <p>current name: ${user.getName()}</p>
        <form action="/update.html" method="post">
            <input type="hidden" value="name" name="kind">
            <input type="text" placeholder="enter new name" name="value">
            <input type="submit" value="update name">
        </form>
    </div>
    <div>
        <c:if test="${adminRoleNumber==role.getNumber()}">
            <p>current role: ${user.getRole()}</p>
            <form action="/update.html" method="post">
                <input type="hidden" value="role" name="kind">
                <select name="value">
                    <option>User</option>
                    <option>Admin</option>
                    <option>Lawer</option>
                </select>
                <input type="submit" value="update role">
            </form>
        </c:if>
    </div>
    <div>
        <c:if test="${adminRoleNumber!=role.getNumber()}">
            <p>current password: ${user.getPassword()}</p>
            <form action="/update.html" method="post">
                <input type="hidden" value="password" name="kind">
                <input type="password" placeholder="enter new password" name="value">
                <input type="password" placeholder="enter new password once more" name="checkPassword">
                <input type="submit" value="update password">
            </form>
        </c:if>
    </div>
    <div>
        <p>current address: ${user.getAddress()}</p>
        <form action="/update.html" method="post">
            <input type="hidden" value="address" name="kind">
            <input type="text" placeholder="enter new address" name="value">
            <input type="submit" value="update address">
        </form>
    </div>
    <div>
        <p>current phone: ${user.getNumber()}</p>
        <form action="/update.html" method="post">
            <input type="hidden" value="phone" name="kind">
            <input type="text" placeholder="enter new phone number" name="value">
            <input type="submit" value="update phone number">
        </form>
    </div>
</body>
</html>
