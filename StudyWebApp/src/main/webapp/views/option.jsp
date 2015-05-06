<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Options:</title>
  </head>
  <body>
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
           
            <td><a href='<%= request.getContextPath() %>/views/OptionDelete.go?id=${option.id}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>