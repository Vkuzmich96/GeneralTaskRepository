<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>

<html>
<head>
    <title>Profile</title>
</head>
<body>
    <u:header/>
    <c:set var="kind" value="${param.get('kind')}"/>
    <c:set var="val" value="${param.get('value')}"/>
    <c:choose>
        <c:when test="${kind eq 'name'}">
            <c:set var="setName" value="${val}"/>
        </c:when>
        <c:when test="${kind eq 'address'}">
            <c:set var="sentAddress" value="${val}"/>
        </c:when>
        <c:when test="${kind eq 'phone'}">
            <c:set var="sentPhone" value="${val}"/>
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
                        <c:set var="wrongName" value="${param.get('wrongName')}"/>
                        <c:if test="${wrongName ne null}">
                            <p class="text-danger">${wrongName}</p>
                        </c:if>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="name" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${setName}" class="input100" required placeholder="enter new name" name="value" maxlength="25" minlength="4" pattern="^[-а-яА-ЯёЁa-zA-Z ]{4,45}$">
                            <u:focus/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update name">
                    </form>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                                password
                        </span>
                        <c:set var="wrongPassword" value="${param.get('wrongPassword')}"/>
                        <c:if test="${wrongPassword ne null}">
                            <p class="text-danger">${wrongPassword}</p>
                        </c:if>
                    </div>
                    <form  action="/update.html" method="post">
                        <input type="hidden" value="password" required name="kind">
                        <div class="wrap-input100">
                             <input type="password" class="input100" required placeholder="enter new password" name="value"  minlength="4" maxlength="12" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                            <u:focus/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update password">
                    </form>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                            current address: ${user.getAddress()}
                        </span>
                        <c:set var="wrongAddress" value="${param.get('wrongAddress')}"/>
                        <c:if test="${wrongAddress ne null}">
                            <p class="text-danger">${wrongAddress}</p>
                        </c:if>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="address" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${sentAddress}" class="input100" required placeholder="enter new address" name="value" maxlength="50" minlength="4" pattern="[-а-яА-ЯёЁa-zA-Z0-9 ,.]{4,50}$">
                            <u:focus/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update address">
                    </form>
                </div>
                <div>
                    <div class="text-center">
                        <span class="txt1">
                            current phone: +${user.getNumber()}
                        </span>
                        <c:set var="wrongNumber" value="${param.get('wrongNumber')}"/>
                        <c:if test="${wrongNumber ne null}">
                            <p class="text-danger">${wrongNumber}</p>
                        </c:if>
                    </div>
                    <form action="/update.html" method="post">
                        <input type="hidden" value="phone" name="kind">
                        <div class="wrap-input100">
                            <input type="text" value="${sentPhone}" class="input100" required placeholder="enter new phone number" name="value" maxlength="12" minlength="12" pattern="^[-0-9]{12,}$">
                            <u:focus/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="update phone number">
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
