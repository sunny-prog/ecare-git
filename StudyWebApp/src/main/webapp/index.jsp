<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false"%>

<html>
  <head>
      <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet"/>
      <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css"/>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
   <title>eCare - Enjoy your live!</title>
  </head>
  <body>
  <jsp:include page="views/header.jsp"  flush="true">
      <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <div class="nav">
      <div class="container">
          <ul class="pull-left">
              <li><a href="<%=request.getContextPath()%>/Tariff.go">Tariffs</a></li>
              <li><a href="<%=request.getContextPath()%>/Option.go">Options</a></li>
           </ul>
          <ul class="pull-right">
              <li><a href="#">Search</a></li>
              <li><a href="views/salesman.jsp">Sign in</a></li>
          </ul>
      </div>
  </div>
  <jsp:include page="views/footer.jsp" flush="true"/>
  </body>
</html>