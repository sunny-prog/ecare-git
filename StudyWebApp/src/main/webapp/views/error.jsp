<%@ page isErrorPage="true" %>
<html>
  <head>
    <title>errors jsp</title>
  </head>
  <body>
  <jsp:include page="header.jsp"  flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
    <div>
      <b>Hello from JSP!</b>
    </div>
    <hr/>
    <p>StackTrace:</p>
    <% if (exception != null) exception.getStackTrace(); %>
  </body>
</html>