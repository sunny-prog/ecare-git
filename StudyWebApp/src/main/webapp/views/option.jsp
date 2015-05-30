<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 22.05.2015
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
    <title>Option</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
</jsp:include>
<jsp:include page="salesman_menu.jsp" flush="true"/>
<form method="POST" action='<%= request.getContextPath() %>/OptionAddUpdate.go' name="frmAddUser">
    <% String action = request.getParameter("action");
        System.out.println(action);
    %>

    Title: <input
        type="text" name="title"
        value="<c:out value="${option.title}" />"/> <br/>
    Price: <input
        type="text" name="price" value="<c:out value="${option.price}" />"/> <br/>
    Activation cost: <input
        type="text" name="activationCost"
        value="<c:out value="${option.activationCost}" />"/><br/>


    <%-- if option is updated - id exists and should be sent in request--%>
    <% if (request.getParameter("id") != null) {%>
    <input type="hidden" name="id" value="<c:out value="${option.id}" />"/>
    <%} else {%>
    <input type="hidden" name="id" value="<c:out value="" />"/>
    <%}%>

    <input type="submit" value="Submit"/>
</form>
</body>
</html>
