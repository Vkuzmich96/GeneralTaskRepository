<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>registration</title>
</head>
<body>

<h1>Registration</h1>

<form action="/registration.html" method="post">
    <label>
        <input type="text" placeholder="email" name="email">
        <p/>
        <input type="text" placeholder="password" name="password">
        <p/>
        <input type="text" placeholder="name" name="name">
        <p/>
        <input type="text" placeholder="address" name="address">
        <p/>
        <input type="text" placeholder="number" name="number">
    </label>
    <input type="submit" value="send">
</form>

</body>
</html>