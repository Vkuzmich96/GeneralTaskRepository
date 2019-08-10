<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Registration</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../support/css/util.css">
    <link rel="stylesheet" type="text/css" href="../support/css/main.css">
    <link rel="stylesheet" type="text/css" href="../support/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
            <form action="/registration.html" method="post">
                <c:set var="isFilled" value="${not empty param}"/>
                <span class="login100-form-title p-b-33">
						Registration
				</span>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                ${param.get("wrongEmail")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("email")}" placeholder="Email" name="email" required class="input100" minlength="5" maxlength="50" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$">
                    <u:focus/>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                ${param.get("wrongPassword")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                    <input type="text" value="${param.get("password")}" placeholder="Password" name="password" required class="input100" minlength="4" maxlength="12" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                    <u:focus/>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                ${param.get("wrongName")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("name")}" placeholder="Name" name="name" class="input100" required maxlength="25" minlength="4" pattern="^[-а-яА-ЯёЁa-zA-Z ]{4,45}$">
                    <u:focus/>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                ${param.get("wrongAddress")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("address")}" placeholder="Address" name="address" required class="input100" maxlength="50" minlength="4" pattern="[-а-яА-ЯёЁa-zA-Z0-9 ,.]{4,50}$">
                    <u:focus/>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1 text-danger">
                                ${param.get("wrongNumber")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("number")}" placeholder="Phone number" name="number" required class="input100" maxlength="12" minlength="12" pattern="^[-0-9]{12,}$">
                    <u:focus/>
                </div>
                <div class="container-login100-form-btn m-t-20">
                    <input type="submit" value="Sign up" class="login100-form-btn">
                </div>
                <div class="text-center">
						<span class="txt1">
							Return to Login?
						</span>
                    <a href="/enter.jsp" class="txt2 hov1">
                        Sign in
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>