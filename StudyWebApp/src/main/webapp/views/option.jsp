<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 22.05.2015
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
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
            <ul class="nav nav-pills nav-stacked red" id="NavParent">
                <li class="">
                    <a href="<%=request.getContextPath()%>/Option.go" onclick="MenuToggle(this)">List All</a></li>
                <li><a href="<%=request.getContextPath()%>/OptionPrepareAdd.go" onclick="MenuToggle(this)">Add new</a></li>
            </ul>
        </div>
        <div class="col-md-8">
            <form class="form-horizontal" role="form" method="POST"
                  action='<%= request.getContextPath() %>/OptionAddUpdate.go' name="frmAddUpdateOption">
                <% String action = request.getParameter("action");
                    System.out.println(action);
                %>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="optionTitle"
                               type="text" name="title"
                               value="<c:out value="${option.title}" />"/>
                     </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Price</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="optionPrice"
                               type="text" name="price"
                               value="<c:out value="${option.price}" />"/>
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Activation cost</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="optionActivationCost"
                               type="text" name="activationCost"
                               value="<c:out value="${option.activationCost}" />"/>
                    </div>
                </div>
                <%-- if option is updated - id exists and should be sent in request--%>
                <% if (request.getParameter("id") != null) {%>
                <input type="hidden" name="id" value="<c:out value="${option.id}" />"/>
                <%} else {%>
                <input type="hidden" name="id" value="<c:out value="" />"/>
                <%}%>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
                <%--input type="submit" value="Submit"--%>
            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" flush="true"/>
</body>

</html>
