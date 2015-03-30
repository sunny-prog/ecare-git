<%@ page isErrorPage="true" %>
<html>
  <head>
    <title>errors jsp</title>
  </head>
  <body>
    <div>
      <b>Hello from JSP!</b>
    </div>
    <hr/>
    <p>StackTrace:</p>
    <% if (exception != null) exception.getStackTrace(); %>
  </body>
</html>