<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp"%>

<html>
  <head>
    <title>Main page</title>
  </head>
  <body>
    <div>
      <b>Content</b>
    </div>
    <hr/>
    <a href="<%=request.getContextPath()%>/views/User.go">List of users</a>
    <a href="<%=request.getContextPath()%>/views/Tariff.go">List of tariffs</a>
    <a href="<%=request.getContextPath()%>/views/Option.go">List of options</a>
    <a href="<%=request.getContextPath()%>/views/Contract.go">List of contracts</a>
  </body>
</html>