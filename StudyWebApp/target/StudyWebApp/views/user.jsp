<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Users:</title>
  </head>
  <body>
    <div>
      <table>
        <thead>
          <tr><th><strong>Name</strong></th><th><strong>Email</strong></th><th><strong>Age</strong></th><th><strong>delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.list}">
          <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a href='<%= request.getContextPath() %>/views/UserDelete.go?email=${user.email}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>