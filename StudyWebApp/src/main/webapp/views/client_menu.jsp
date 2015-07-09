<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 20.05.2015
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <ul class="nav nav-pills pull-left">
        <li class=""><a href="<%=request.getContextPath()%>/TariffLoadList.go">Tariffs</a></li>
        <li><a href="<%=request.getContextPath()%>/OptionLoadList.go">Options</a></li>
        <li><a href="<%=request.getContextPath()%>/ContractLoadList.go">Contract</a></li>
        <li><a href="<%=request.getContextPath()%>/UserLoadList.go">Profile</a></li>
    </ul>
    <ul class="nav nav-pills pull-right">
        <li><a href="#">Search</a></li>
        <li><a href="#">Sign out</a></li>
    </ul>

</div>
<hr/>
</body>
</html>