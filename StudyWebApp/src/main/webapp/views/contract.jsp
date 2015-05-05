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
          <tr><th><strong>Number</strong></th><th><strong>Tariff</strong></th><th><strong>Client</strong></th><th><strong>blocked_by_salesman</strong></th><th><strong>blocked_by_client</strong></th><th><strong>delete</strong></th></tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${requestScope.list}">
          <tr>
            <td>${contract.contractNumber}</td>
            <td>${contract.tariff.title}</td>
            <td>${contract.client.name}</td>
            <td>${contract.blockedBySalesman}</td>
            <td>${contract.blockedByclient}</td>
            <td><a href='<%= request.getContextPath() %>/views/ContractDelete.go?id=${contract.id}'>Del</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>   
    </div>
    <hr/>
  </body>
</html>