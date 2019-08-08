<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="../support/css/util.css">
    <link rel="stylesheet" type="text/css" href="../support/css/main.css">
</head>
<body>
    <u:header/>
    <c:set var="role" value="${role}"/>
    <c:set var="adminRoleNumber" value="1"/>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
                <div>
                    <span>
                        current name: ${user.getName()}
                    </span>
                    <form class="wrap-input100" action="/update.html" method="post">
                        <input type="hidden" value="name" name="kind">
                        <div class="wrap-input100">
                            <input type="text" class="input100" placeholder="enter new name" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <div class="container-login100-form-btn m-t-20">
                            <input type="submit" class="login100-form-btn" value="update name">
                        </div>
                    </form>
                </div>
                <div>
                    <c:if test="${adminRoleNumber==role.getNumber()}">
                        <span>
                            current role: ${user.getRole()}
                        </span>
                        <form class="wrap-input100" action="/update.html" method="post">
                            <input type="hidden" value="role" name="kind">
                            <div class="wrap-input100">
                                <select name="value" class="input100">
                                    <option>User</option>
                                    <option>Admin</option>
                                    <option>Lawyer</option>
                                </select>
                            </div>
                            <div class="container-login100-form-btn m-t-20">
                                <input type="submit" class="login100-form-btn" value="update role">
                            </div>
                        </form>
                    </c:if>
                </div>
                <div>
                    <c:if test="${adminRoleNumber!=role.getNumber()}">
                        <span>
                            password
                        </span>
                        <form  action="/update.html" method="post">
                            <input type="hidden" value="password" name="kind">
                            <div class="wrap-input100">
                                <input type="password" class="input100" placeholder="enter new password" name="value">
                                <span class="focus-input100-1"></span>
                                <span class="focus-input100-2"></span>
                            </div>
                            <div class="container-login100-form-btn m-t-20">
                                <input type="submit" class="login100-form-btn" value="update password">
                            </div>
                        </form>
                    </c:if>
                </div>
                <div>
                    <span>
                        current address: ${user.getAddress()}
                    </span>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="address" name="kind">
                        <div class="wrap-input100">
                            <input type="text" class="input100" placeholder="enter new address" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <div class="container-login100-form-btn m-t-20">
                            <input type="submit" class="login100-form-btn" value="update address">
                        </div>
                    </form>
                </div>
                <div>
                    <span>
                        current phone: ${user.getNumber()}
                    </span>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="phone" name="kind">
                        <div class="wrap-input100">
                            <input type="text" class="input100" placeholder="enter new phone number" name="value">
                            <span class="focus-input100-1"></span>
                            <span class="focus-input100-2"></span>
                        </div>
                        <div class="container-login100-form-btn m-t-20">
                            <input type="submit" class="login100-form-btn" value="update phone number">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
