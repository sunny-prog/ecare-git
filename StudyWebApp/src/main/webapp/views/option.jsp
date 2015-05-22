<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
  <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
  <title>Options</title>
</head>
  <body>
  <jsp:include page="header.jsp"  flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <jsp:include page="salesman_menu.jsp"  flush="true"/>
    <div>
      <table>
        <thead>
          <tr><th><strong>Title</strong></th><th><strong>Price</strong></th><th><strong>ActivationCost</strong></th><th><strong>Delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="option" items="${requestScope.list}">
          <tr>
            <td>${option.title}</td>
            <td>${option.price}</td>
            <td>${option.activationCost}</td>
            <td><a href='<%= request.getContextPath() %>/views/OptionDelete.go?id=${option.id}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>