<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
  <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
  <title>Contracts</title>
</head>
  <body>
  <jsp:include page="header.jsp"  flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <jsp:include page="salesman_menu.jsp"  flush="true"/>
    <div>
      <table>
        <thead>
          <tr><th><strong>Number</strong></th><th><strong>Tariff</strong></th><th><strong>Client</strong></th><th><strong>blocked_by_salesman</strong></th><th><strong>blocked_by_client</strong></th><th><strong>delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${requestScope.list}">
          <tr>
            <td>${contract.contractNumber}</td>
            <td>${contract.tariff.title}</td>
            <td>${contract.client.name}</td>
            <td>${contract.blockedBySalesman}</td>
            <td>${contract.blockedByClient}</td>
            <td><a href='<%= request.getContextPath() %>/ContractDelete.go?id=${contract.id}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>