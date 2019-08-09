<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Registration</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../support/css/util.css">
    <link rel="stylesheet" type="text/css" href="../support/css/main.css">
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
                        <span class="txt1">
                                ${param.get("wrongEmail")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input type="text" placeholder="Email" name="email" class="input100">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1">
                                ${param.get("wrongPassword")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                    <input type="text" placeholder="Password" name="password" class="input100">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1">
                                ${param.get("wrongName")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" placeholder="Name" name="name" class="input100">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1">
                                ${param.get("wrongAddress")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" placeholder="Address" name="address" class="input100">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <c:if test="${isFilled}">
                    <div class="text-center">
                        <span class="txt1">
                                ${param.get("wrongNumber")}
                        </span>
                    </div>
                </c:if>
                <div class="wrap-input100">
                    <input type="text" placeholder="Phone number" name="number" class="input100">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
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