<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>

<html>
<head>
    <title>Profile</title>
</head>
<body>
    <u:header/>
    <c:set var="role" value="${role}"/>
    <c:set var="adminRoleNumber" value="1"/>
    <c:set var="kind" value="${param.get('kind')}"/>
    <c:set var="val" value="${param.get('value')}"/>
    <c:choose>
        <c:when test="${kind eq 'name'}">
            <c:set var="wrongName" value="${val}"/>
        </c:when>
        <c:when test="${kind eq 'role'}">
            <c:set var="wrongRole" value="${val}"/>
        </c:when>
        <c:when test="${kind eq 'address'}">
            <c:set var="wrongAddress" value="${val}"/>
        </c:when>
        <c:when test="${kind eq 'phone'}">
            <c:set var="wrongPhone" value="${val}"/>
        </c:when>
    </c:choose>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                <div>
                    <div class="text-center">
                        <span class="txt1">
                            current name: ${user.getName()}
                        </span>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="name" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${wrongName}" class="input100" required placeholder="enter new name" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update name">
                    </form>
                </div>
                <div>
                    <c:if test="${adminRoleNumber==role.getNumber()}">
                        <div class="text-center">
                            <span class="txt1">
                                current role: ${user.getRole()}
                            </span>
                        </div>
                        <form class="wrap-input100" action="/update.html" method="post">
                            <input type="hidden" value="role" name="kind">
                            <div class="wrap-input100">
                                <select value="${wrongRole}" name="value" required class="input100">
                                    <option>User</option>
                                    <option>Admin</option>
                                    <option>Lawyer</option>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-primary" value="update role">
                        </form>
                    </c:if>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                                password
                        </span>
                    </div>
                    <form  action="/update.html" method="post">
                        <input type="hidden" value="password" required name="kind">
                        <div class="wrap-input100">
                             <input type="password" class="input100" required placeholder="enter new password" name="value">
                             <span class="focus-input100-1"></span>
                             <span class="focus-input100-2"></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update password">
                    </form>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                            current address: ${user.getAddress()}
                        </span>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="address" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${wrongAddress}" class="input100" required placeholder="enter new address" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update address">
                    </form>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                            current phone: +${user.getNumber()}
                        </span>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="phone" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${wrongPhone}" class="input100" required placeholder="enter new phone number" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update phone number">
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
