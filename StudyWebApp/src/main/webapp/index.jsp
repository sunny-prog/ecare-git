<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <title>eCare - Enjoy your live!</title>
</head>
<body>
<jsp:include page="views/header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
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
<jsp:include page="views/footer.jsp" flush="true"/>
</body>
</html>