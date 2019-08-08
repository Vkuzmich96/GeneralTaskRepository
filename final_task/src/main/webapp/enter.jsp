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
                <c:if test="${not empty massage}">
                    <div class="text-center">
                        <span class="txt1">
                            ${massage}
                        </span>
                    </div>
                </c:if>
                ${wrongEmail}
                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input type="text" name="email" class="input100" placeholder="Email">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                ${wrongPassword}
                <div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
                    <input type="text" class="input100" name="password"  placeholder="Password" >
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
