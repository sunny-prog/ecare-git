<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
    <title>Clients</title>
  </head>
  <body>
  <jsp:include page="header.jsp"  flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <jsp:include page="salesman_menu.jsp"  flush="true"/>
    <div>
      <table>
        <thead>
          <tr><th><strong>Name</strong></th><th><strong>Surname</strong></th><th><strong>Email</strong></th><th><strong>Age</strong></th><th><strong>delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.list}">
          <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><form  action="<%= request.getContextPath() %>/UserDelete.go" method="post"><input type="hidden" name="id" value="${user.id}"/><input type="submit"  value="Delete"/></form></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>