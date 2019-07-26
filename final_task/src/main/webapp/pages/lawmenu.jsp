<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.07.2019
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LawerMenu</title>
</head>
<body>
    <form action="/addMap" method="post">
        <p>Add map</p>
        <input type="text" placeholder="enter map name" name="name"/>
        <p/>
        <input type="submit" value="add"/>
    </form>
    <form action="/addAction.html" method="post">
        <p>Add action</p>
        <input type="text" placeholder="enter action name" name="name">
        <p/>
        <input type="text" placeholder="enter description" name="description">
        <p/>
        <input type="submit" value="add"/>
    </form>
    <form action="/addMaterial.html" method="post">
        <p>Add material</p>
        <input type="text" placeholder="enter material name" name="name">
        <p/>
        <input type="text" placeholder="enter description" name="description">
        <p/>
        <input type="file" name="file">
        <p/>
        <input type="submit" value="add"/>
    </form>
</body>
</html>
