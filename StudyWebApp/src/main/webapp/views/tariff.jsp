<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 22.05.2015
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tariff</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="subTitle" value="We care about your connection!"/>
</jsp:include>
<jsp:include page="restricted/salesman/salesman_menu.jsp" flush="true"/>
<div class="container" id="wrap">
    <div class="row">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked red" id="NavParent">
                <li class="">
                    <a href="<%=request.getContextPath()%>/TariffLoadList.go" onclick="MenuToggle(this)">List All</a>
                </li>
                <li><a href="<%=request.getContextPath()%>/TariffPrepareAdd.go" onclick="MenuToggle(this)">Add new</a>
                </li>
            </ul>
        </div>
        <div class="col-md-8">
            <c:set var="tariffRequestScope" value="${requestScope.tariff}"/>
            <form class="form-horizontal" role="form" method="POST"
                  action='<%= request.getContextPath() %>/TariffAddUpdate.go' name="frmAddUpdateTariff">
                <% String action = request.getParameter("action");
                    System.out.println(action);
                %>

                <div class="form-group">

                    <label class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="optionTitle"
                               type="text" name="title"
                               value="<c:out value="${tariffRequestScope.title}" />"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Price</label>

                    <div class="col-sm-6 inputGroupContainer">
                        <div class="input-group">
                            <input class="form-control" id="tariffPrice"
                                   type="text" name="price"
                                   value="<c:out value="${tariffRequestScope.price}" />"/>
                            <span class="input-group-addon">&#8381</span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Options</label>

                    <div class="col-md-6">
                        <c:set var="action" value="${requestScope.action}"/>
                        <c:choose>
                            <c:when test="${action == 'add'}">
                                <c:forEach var="existingOption" items="${requestScope.existingOptionsList}">
                                    <div class="checkbox">
                                        <label for="checkboxes-0">
                                            <input type="checkbox" name="chosenOptionIds" id="checkboxes-0"
                                                   value="${existingOption.id}">
                                                ${existingOption.title}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <!-- if action is update - need to load options already chosen in tariff-->

                                <c:forEach var="existingOption"
                                           items="${requestScope.existingOptionsList}">
                                    <c:set var="iSCheckboxChecked" value="false"/>
                                    <c:forEach var="availableForTariffOption" items="${requestScope.availableForTariffOptionsList}">
                                        <c:choose>
                                            <%-- If the availableForTariffOption was selected for this tariff ealier, the related checkbox will be checked. Otherwise unchecked. --%>
                                            <c:when test="${availableForTariffOption.id == existingOption.id}">
                                                <c:set var="iSCheckboxChecked" value="true"/>
                                            </c:when>
                                            <c:otherwise>
                                                <!--c:set var="iSCheckboxChecked" value="false"/-->
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <div class="checkbox">
                                        <label for="checkboxes-0">
                                            <input type="checkbox" name="chosenOptionIds" value="${existingOption.id}"
                                                   <c:if test="${iSCheckboxChecked}">checked="checked"</c:if>>${existingOption.title}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <%-- if tariff is updated - id exists and should be sent in request--%>
                <% if (request.getParameter("id") != null) {%>
                <input type="hidden" name="id" value="<c:out value="${tariffRequestScope.id}" />"/>
                <%} else {%>
                <input type="hidden" name="id" value="<c:out value="" />"/>
                <%}%>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
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

