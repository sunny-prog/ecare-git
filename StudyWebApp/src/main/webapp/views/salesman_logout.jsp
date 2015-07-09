<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 08.07.2015
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 22.05.2015
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Option</title>
</head>
<body>

<jsp:include page="header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
</jsp:include>
<jsp:include page="salesman_menu.jsp" flush="true"/>
<div class="container">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <form class="form-horizontal" id="ShiftDownLoginForm" role="form" method="POST"
                  action="<%= request.getContextPath() %>/LogoutServlet">

                <div class="text-center"><h4>Are you sure you want to log out?</h4>

                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" flush="true"/>
</body>

</html>
