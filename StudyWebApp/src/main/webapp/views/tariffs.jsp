<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Options</title>
</head>
<body>
<div id="wrap">
  <jsp:include page="header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
  </jsp:include>
  <jsp:include page="salesman_menu.jsp" flush="true"/>
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <ul class="nav nav-pills nav-stacked red" id="NavParent">
          <li>
            <a href="<%=request.getContextPath()%>/TariffLoadList.go" onclick="MenuToggle(this)">List All</a></li>
          <li><a href="<%=request.getContextPath()%>/TariffPrepareAdd.go" onclick="MenuToggle(this)">Add new</a></li>
        </ul>
      </div>
      <div class="col-md-8">
        <table class="table table-striped table-hover table-condensed">
          <thead>
          <tr>
            <th><strong>Title</strong></th>
            <th><strong>Price</strong></th>
            <th><strong>Operation</strong></th>
            <th><strong>Operation</strong></th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="tariff" items="${requestScope.list}">
            <tr>
              <td>${tariff.title}</td>
              <td>${tariff.price}</td>
              <td>
                <form class="formButton" action="<%= request.getContextPath() %>/TariffDelete.go"
                      method="post"><input
                        type="hidden" name="id" value="${tariff.id}"/><input type="submit"
                                                                             class="btn btn-link btn-xs"
                                                                             value="Delete"/>
                </form>
              </td>
              <td>
                <form class="formButton" action="<%= request.getContextPath() %>/TariffPrepareUpdate.go"
                      method="post"><input
                        type="hidden" name="id" value="${tariff.id}"/><input type="submit"
                                                                             class="btn btn-link btn-xs"
                                                                             value="Update"/>
                </form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="col-md-3">
      </div>

    </div>
  </div>
</div>
<%--wrap ends here--%>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>