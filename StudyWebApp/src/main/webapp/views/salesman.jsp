<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false"%>

<html>
<head>
  <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
  <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
  <title>eCare - Enjoy your live!</title>
</head>
<body>
<jsp:include page="header.jsp"  flush="true">
  <jsp:param name="subTitle" value="Customer delight drives our action"/>
</jsp:include>
<jsp:include page="salesman_menu.jsp"  flush="true"/>
</body>
</html>