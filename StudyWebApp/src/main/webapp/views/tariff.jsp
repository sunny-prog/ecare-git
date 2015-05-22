<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
  <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
  <title>Tariffs</title>
</head>
  <body>
  <jsp:include page="header.jsp"  flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <jsp:include page="salesman_menu.jsp"  flush="true"/>
    <div>
      <table>
        <thead>
          <tr><th><strong>Price</strong></th><th><strong>Title</strong></th><th><strong>delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="tariff" items="${requestScope.list}">
          <tr>
            <td>${tariff.price}</td>
            <td>${tariff.title}</td>
            <td><a href='<%= request.getContextPath() %>/views/TariffDelete.go?id=${tariff.id}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>