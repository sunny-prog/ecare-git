<%@ page language="java" contentType="text/html;" trimDirectiveWhitespaces="false" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contracts</title>
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
                        <a href="<%=request.getContextPath()%>/ContractLoadList.go" onclick="MenuToggle(this)">List All</a></li>
                    <li><a href="<%=request.getContextPath()%>/ContractPrepareAdd.go" onclick="MenuToggle(this)">Add
                        new</a></li>
                </ul>
            </div>
            <div class="col-md-8">
                <table class="table table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <th><strong>Number</strong></th>
                        <th><strong>Tariff</strong></th>
                        <th><strong>Client</strong></th>
                        <th><strong>Blocked by salesman</strong></th>
                        <th><strong>Blocked by client</strong></th>
                        <th><strong>Operation</strong></th>
                        <th><strong>Operation</strong></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="contract" items="${requestScope.list}">
                        <tr>
                            <td>${contract.number}</td>
                            <td>${contract.tariff.id}</td>
                            <td>${contract.client.id}</td>
                            <td>${contract.blockedBySalesman}</td>
                            <td>${contract.blockedByClient}</td>
                            <td>
                                <form class="formButton" action="<%= request.getContextPath() %>/ContractDelete.go"
                                      method="post"><input
                                        type="hidden" name="id" value="${contract.id}"/><input type="submit"
                                                                                             class="btn btn-link btn-xs"
                                                                                             value="Delete"/>
                                </form>
                            </td>
                            <td>
                                <form class="formButton" action="<%= request.getContextPath() %>/ContractPrepareUpdate.go"
                                      method="post"><input
                                        type="hidden" name="id" value="${contract.id}"/><input type="submit"
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