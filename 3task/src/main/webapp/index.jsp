<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>

<h2>Enter parameters</h2>

<form action="/parse" method="post">
    <label>
        <input type="text" name="url" placeholder="url">
        <select name="chose">
            <option>DOM</option>
            <option>SAX</option>
            <option>StaX</option>
        </select>
        <input type="submit" value="parse"/>
    </label>
</form>

</body>
</html>