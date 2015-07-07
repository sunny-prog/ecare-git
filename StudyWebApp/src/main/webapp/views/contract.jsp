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
  <title>Contract</title>
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
          <a href="<%=request.getContextPath()%>/ContractLoadList.go" onclick="MenuToggle(this)">List All</a></li>
        <li><a href="<%=request.getContextPath()%>/contractPrepareAdd.go" onclick="MenuToggle(this)">Add new</a></li>
      </ul>
    </div>
    <div class="col-md-8">
      <form class="form-horizontal" id="AddUpdateForm" role="form" method="POST"
            action='<%= request.getContextPath() %>/ContractAddUpdate.go' name="frmAddUpdateContract">
        <% String action = request.getParameter("action");
          System.out.println(action);
        %>
        <div class="form-group">

          <label class="col-sm-2 control-label">Contract number</label>

          <div class="col-sm-6">
            <input class="form-control" id="contractNumber"
                   type="text" name="number"
                   value="<c:out value="${contract.number}" />"/>
          </div>
        </div>
        <div class="form-group">

          <label class="col-sm-2 control-label">Tariff</label>

          <div class="col-sm-6">
            <input class="form-control" id="contractTariff"
                   type="text" name="tariffId"
                   value="<c:out value="${contract.tariff.id}" />"/>
          </div>
        </div>
        <div class="form-group">

          <label class="col-sm-2 control-label">Client</label>

          <div class="col-sm-6">
            <input class="form-control" id="contractClient"
                   type="text" name="clientId"
                   value="<c:out value="${contract.client.id}" />"/>
          </div>
        </div>
        <div class="form-group">

        <label class="col-sm-2 control-label">Blocked by salesman</label>

        <div class="col-sm-6">
          <input class="form-control" id="contractBlockedBySalesman"
                 type="text" name="blockedBySalesman"
                 value="<c:out value="${contract.blockedBySalesman}" />"/>
        </div>
      </div>
        <div class="form-group">

          <label class="col-sm-2 control-label">Blocked by salesman</label>

          <div class="col-sm-6">
            <input class="form-control" id="contractBlockedByClient"
                   type="text" name="blockedByClient"
                   value="<c:out value="${contract.blockedByClient}" />"/>
          </div>
        </div>
        <%-- if option is updated - id exists and should be sent in request--%>
        <% if (request.getParameter("id") != null) {%>
        <input type="hidden" name="id" value="<c:out value="${contract.id}" />"/>
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
