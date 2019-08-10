<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.07.2019
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="support/css/util.css">
    <link rel="stylesheet" type="text/css" href="support/css/main.css">
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
            <form action="/enter.html" method="post" class="login100-form validate-form">
                <span class="login100-form-title p-b-33">
                    Account Login
				</span>
                <c:if test="${not empty param}">
                    <div class="text-center">
                        <span class="txt1">
                                ${param.get("wrongLoginOrPassword")}
                        </span>
                    </div>
                </c:if>

                <div class="wrap-input100">
                    <input type="text" value="${param.get("email")}" name="email" class="input100" required placeholder="Email" minlength="4" maxlength="30" pattern="^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100">
                    <input type="text" value="${param.get("password")}" name="password" class="input100" required placeholder="Password" minlength="4" maxlength="12" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>

                <div class="container-login100-form-btn m-t-20">
                    <input type="submit" value="Sign in" class="login100-form-btn">
                </div>

                <div class="text-center">
					<span class="txt1">
							Create an account?
					</span>
                    <a href="/pages/registration.jsp" class="txt2 hov1">
                        Sign up
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
