<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 08.07.2015
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" %>

<html>
<head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <title>eCare - Enjoy your live!</title>
</head>
<body>
<jsp:include page="views/header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
</jsp:include>
<div class="nav">
    <div class="container">
        <ul class="pull-left">
            <li><a href="#">About us</a></li>
            <li><a href="#">Contact us</a></li>
            <li><a href="#">Help</a></li>

        </ul>
        <ul class="pull-right">
            <li><a href="#">Search</a></li>
            <!-- li><a href="views/login.jsp">Sign in</a></li-->
        </ul>
    </div>
</div>
<hr/>
<div class="container">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-7">
            <form class="form-horizontal" id="ShiftDownLoginForm" role="form" method="POST"
                  action="<%=request.getContextPath()%>/UserLogin.go">

                <div class="col-sm-offset-2" style="color:red"><h5>${ErrorMessage}</h5></div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Login</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="login"
                               type="text" name="login"/>

                        <div style="color:red">${loginErrorMessage}</div>
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="password"
                               type="password" name="password"/>

                        <div style="color:red">${passwordErrorMessage}</div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>
<jsp:include page="views/footer.jsp" flush="true"/>
</body>
</html>
