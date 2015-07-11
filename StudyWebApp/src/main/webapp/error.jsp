<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 08.07.2015
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>eCare - Enjoy your live!</title>
</head>
<body>
<jsp:include page="views/header.jsp" flush="true">
    <jsp:param name="subTitle" value="Be attentive!"/>
</jsp:include>
<c:set var="role" value="${sessionScope.user.role}"/>
<c:choose>
    <c:when  test="${role == 'CLIENT'}">
        <jsp:include page="views/restricted/client/client_menu.jsp" flush="true"/>
    </c:when>
    <c:when  test="${role == 'SALESMAN'}">
        <jsp:include page="views/restricted/salesman/salesman_menu.jsp" flush="true"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="general_menu.jsp" flush="true"/>
    </c:otherwise>
</c:choose>

<div class="container">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">

            <div class="panel panel-default">
                <div class="panel-heading">HTTP Status</div>
                <div class="panel-body">${HttpStatus}</div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Error message</div>
                <div style="color:red" class="panel-body">${ErrorMessage}</div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Stack trace</div>
                <div class="panel-body">${StackTrace}</div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<jsp:include page="views/footer.jsp" flush="true"/>
</body>
</html>