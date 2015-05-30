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
            <td><form  action="<%= request.getContextPath() %>/OptionDelete.go" method="post"><input type="hidden" name="id" value="${option.id}"/><input type="submit"  value="Delete"/></form></td>
            <td><form  action="<%= request.getContextPath() %>/OptionPrepareEdit.go" method="post"><input type="hidden" name="id" value="${option.id}"/><input type="submit"  value="Update"/></form></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  <p><a href="<%= request.getContextPath() %>/OptionPrepareAdd.go">Add Option</a></p>
    <hr/>
  </body>
</html>