<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 19.05.2015
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <%--link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css"--%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-override.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/stickyfooter.css"/>
    <title>eCare - Enjoy your live!</title>
</head>
<body>
<div class="header">
    <div class="container">
        <h1>eCare</h1>
        <em>${param.subTitle}</em>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>
