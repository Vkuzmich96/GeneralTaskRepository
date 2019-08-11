<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/treePrinterTag" prefix="d"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<html>
<head>
    <title>LawyerMenu</title>
</head>
<body>
<u:header/>
<c:if test="${param.get('graphId') eq null}">
    <div class="container">
        <form action="/addMap.html" method="post">
            <div class="form-group text-center">
                <p class="text-left">Create map</p>
                <input class="form-control" type="text" placeholder="enter map name" name="name"/>
                <div class="text-left">
                    <input type="submit" class="btn btn-primary" value="create"/>
                </div>
            </div>
        </form>
    </div>
</c:if>

<c:if test="${param.get('graphId') ne null}">
    <div class="container">
        <form action="/addAction.html" method="post" enctype="multipart/form-data">
            <div>
                <input type="hidden" value="${param.get('graphId')}" name="graphId">
                <input type="hidden" value="${param.get('step')}" name="step">
                <input type="hidden" value="${param.get('actionId')}" name="actionId">
                <input type="hidden" value="${param.get('actualActionId')}" name="actualActionId">
            </div>
            <div class="form-group text-center">
                <u:actiomBody/>
                <div class="text-left">
                    <input type="file" name="file">
                    <input type="submit" class="btn btn-primary" value="add"/>
                    <input type="checkbox" name="isNext"> next step
                    <a href="/release.html?number=${param.get('graphId')}" class="btn btn-primary"> release map </a>
                    <a href="/delete.html?number=${param.get('graphId')}" class="btn btn-primary"> delete map </a>
                </div>
            </div>
        </form>
        <d:graph number="${param.get('graphId')}"/>
    </div>
</c:if>
</body>
</html>
