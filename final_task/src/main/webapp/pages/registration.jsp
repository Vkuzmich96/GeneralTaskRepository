<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../support/css/util.css">
    <link rel="stylesheet" type="text/css" href="../support/css/main.css">
    <link rel="stylesheet" type="text/css" href="../support/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
            <fmt:setLocale value="${not empty cookie.lang.value ? cookie.lang.value : 'en'}"/>
            <fmt:setBundle basename="label"/>
            <form action="/registration.html" method="post">
                <span class="login100-form-title p-b-33">
						<fmt:message key="registration"/>
				</span>
                <c:set var="wrongEmail" value="${param.get('wrongEmail')}"/>
                <c:if test="${wrongEmail ne null}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                <fmt:message key="${wrongEmail}"/>
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("email")}" placeholder="<fmt:message key="email"/>" name="email" required class="input100" minlength="5" maxlength="50" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$">
                    <u:focus/>
                </div>
                <c:set var="wrongPassword" value="${param.get('wrongPassword')}"/>
                <c:if test="${wrongPassword ne null}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                <fmt:message key="${wrongPassword}"/>
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                    <input type="text" value="${param.get("password")}" placeholder="<fmt:message key="password"/>" name="password" required class="input100" minlength="4" maxlength="12" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                    <u:focus/>
                </div>
                <c:set var="wrongName" value="${param.get('wrongName')}"/>
                <c:if test="${wrongName ne null}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                <fmt:message key="${wrongName}"/>
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("name")}" placeholder="<fmt:message key="name"/>" name="name" class="input100" required maxlength="25" minlength="4" pattern="^[-а-яА-ЯёЁa-zA-Z ]{4,45}$">
                    <u:focus/>
                </div>
                <c:set var="wrongAddress" value="${param.get('wrongAddress')}"/>
                <c:if test="${wrongAddress ne null}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                <fmt:message key="${wrongAddress}"/>
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("address")}" placeholder="<fmt:message key="address"/>" name="address" required class="input100" maxlength="50" minlength="4" pattern="[-а-яА-ЯёЁa-zA-Z0-9 ,.]{4,50}$">
                    <u:focus/>
                </div>
                <c:set var="wrongNumber" value="${param.get('wrongNumber')}"/>
                <c:if test="${wrongNumber ne null}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                <fmt:message key="${wrongNumber}"/>
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("number")}" placeholder="<fmt:message key="phone.number"/>" name="number" required class="input100" maxlength="12" minlength="12" pattern="^[-0-9]{12,}$">
                    <u:focus/>
                </div>
                <div class="container-login100-form-btn m-t-20">
                    <input type="submit" value="<fmt:message key="sign.up"/>" class="login100-form-btn">
                </div>
                <div class="text-center">
                    <a href="/setLocale.html?locale=en&url=${pageContext.request.requestURI}" class="txt2 hov1">
                        EN
                    </a>
                    <a href="/setLocale.html?locale=ru&url=${pageContext.request.requestURI}" class="txt2 hov1">
                        RU
                    </a>
					<span class="txt1">
						<fmt:message key="return.to.Login"/>
					</span>
                    <a href="/enter.jsp" class="txt2 hov1">
                        <fmt:message key="sign.in"/>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>