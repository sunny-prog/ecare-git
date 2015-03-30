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