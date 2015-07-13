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
<jsp:include page="restricted/salesman/salesman_menu.jsp" flush="true"/>
<div class="container" id="wrap">
    <div class="row">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked red" id="NavParent">
                <li class="">
                    <a href="<%=request.getContextPath()%>/OptionLoadList.go" onclick="MenuToggle(this)">List All</a>
                </li>
                <li><a href="<%=request.getContextPath()%>/OptionPrepareAdd.go" onclick="MenuToggle(this)">Add new</a>
                </li>
            </ul>
        </div>
        <div class="col-md-8">

            <form class="form-horizontal" role="form" method="POST"
                  action='<%= request.getContextPath() %>/OptionAddUpdate.go' name="frmAddUpdateOption">
                <% String action = request.getParameter("action");
                    //System.out.println(action);
                %>
                <c:set var="optionRequestScope" value="${requestScope.option}"/>
                <div style="color:red">${ErrorMessage}</div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Title</label>

                    <div class="col-sm-6">
                        <input class="form-control" id="optionTitle"
                               type="text" name="title"
                               value="<c:out value="${optionRequestScope.title}" />"/>

                        <div style="color:red">${titleErrorMessage}</div>
                    </div>
                </div>
                <div class="form-group">

                    <label class="col-sm-2 control-label">Price</label>

                    <div class="col-sm-6 inputGroupContainer">
                        <div class="input-group">
                            <input class="form-control" id="optionPrice"
                                   type="text" name="price"
                                   value="<c:out value="${optionRequestScope.price}" />"/>
                            <span class="input-group-addon">&#8381</span>
                        </div>
                        <div style="color:red">${priceErrorMessage}</div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Activation cost</label>

                    <div class="col-sm-6 inputGroupContainer">
                        <div class="input-group">
                            <input class="form-control" id="optionActivationCost"
                                   type="text" name="activationCost"
                                   value="<c:out value="${optionRequestScope.activationCost}" />"/>
                            <span class="input-group-addon">&#8381</span>
                        </div>
                        <div style="color:red">${activationCostErrorMessage}</div>
                    </div>
                </div>
                <c:set var="action" value="${requestScope.action}"/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Required options</label>

                    <div class="col-md-8">
<!-- RENDERING REQUIRED OPTIONS -->

<c:choose>
      <c:when test="${action == 'add'}">
          <!-- If action is add new option -->
                        <c:forEach var="existingOption" items="${requestScope.existingOptionsList}">
                            <div class="checkbox-inline">
                                <label>
                                    <input class="checkboxRequired" type="checkbox" name="chosenRequiredOptionIds"
                                           id="${existingOption.id}"
                                           value="${existingOption.id}">
                                        ${existingOption.title}
                                </label>
                            </div>
                        </c:forEach>
    </c:when>
    <c:otherwise>
        <!-- if action is update option - need to load required options stored with option-->
        <c:forEach var="existingOption"
                   items="${requestScope.existingOptionsList}">
            <c:set var="iSCheckboxChecked" value="false"/>
            <c:forEach var="requiredOption" items="${requestScope.requiredOptionsList}">
                <c:choose>
                    <%-- If the required options were selected for this tariff ealier, the related checkbox will be checked. Otherwise unchecked. --%>
                    <c:when test="${requiredOption.id == existingOption.id}">
                        <c:set var="iSCheckboxChecked" value="true"/>
                    </c:when>
                    <c:otherwise>
                        <!--c:set var="iSCheckboxChecked" value="false"/-->
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <div class="checkbox-inline">
                <label>
                    <input type="checkbox" class="checkboxRequired"  name="chosenRequiredOptionIds" value="${existingOption.id}"
                           <c:if test="${iSCheckboxChecked}">checked="checked"</c:if>>${existingOption.title}
                </label>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Incompatible options</label>

                    <div class="col-md-8">
                        <!-- RENDERING INCOMPATIBLE OPTIONS -->

                        <c:choose>
                            <c:when test="${action == 'add'}">
                                <!-- If action is add new option -->
                                <c:forEach var="existingOption" items="${requestScope.existingOptionsList}">
                                    <div class="checkbox-inline">
                                        <label>
                                            <input class="checkboxIncompatible" type="checkbox" name="chosenIncompatibleOptionIds"
                                                   id="${existingOption.id}"
                                                   value="${existingOption.id}">
                                                ${existingOption.title}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <!-- if action is update option - need to load incompatible options stored with option-->
                                <c:forEach var="existingOption"
                                           items="${requestScope.existingOptionsList}">
                                    <c:set var="iSCheckboxChecked" value="false"/>
                                    <c:forEach var="incompatibleOption" items="${requestScope.incompatibleOptionsList}">
                                        <c:choose>
                                            <%-- If the Incompatible options were selected for this option ealier, the related checkbox will be checked. Otherwise unchecked. --%>
                                            <c:when test="${incompatibleOption.id == existingOption.id}">
                                                <c:set var="iSCheckboxChecked" value="true"/>
                                            </c:when>
                                            <c:otherwise>
                                                <!--c:set var="iSCheckboxChecked" value="false"/-->
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <div class="checkbox-inline">
                                        <label>
                                            <input type="checkbox" class="checkboxIncompatible"  name="chosenIncompatibleOptionIds" value="${existingOption.id}"
                                                   <c:if test="${iSCheckboxChecked}">checked="checked"</c:if>>${existingOption.title}
                                        </label>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
                <%-- if option is updated - id exists and should be sent in request--%>
                <% if (request.getParameter("id") != null) {%>
                <input type="hidden" name="id" value="<c:out value="${optionRequestScope.id}" />"/>
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

<script>
    $(document).on('click', '.checkboxIncompatible', function () {
        var cbs = document.getElementsByClassName("checkboxRequired");
        for (var i = 0; i < cbs.length; i++) {
            if ($(cbs[i]).attr("id") === $(this).attr("id")) {
                if (this.checked === true) {
                    $(cbs[i]).attr('disabled', true);
                }
                else {
                    $(cbs[i]).attr('disabled', false);
                }
            }
        }

    })
    $(document).on('click', '.checkboxRequired', function () {
        var cbs = document.getElementsByClassName("checkboxIncompatible");
        for (var i = 0; i < cbs.length; i++) {
            if ($(cbs[i]).attr("id") === $(this).attr("id")) {
                if (this.checked === true) {
                    $(cbs[i]).attr('disabled', true);
                }
                else {
                    $(cbs[i]).attr('disabled', false);
                }
            }
        }

    })
    $(document).ready(function() {
        var cbsRec = document.getElementsByClassName("checkboxRequired");
        var cbsIncomp = document.getElementsByClassName("checkboxIncompatible");
        for (var i = 0; i < cbsRec.length; i++) {
            for (var j = 0; j < cbsIncomp.length; j++) {
                if ($(cbsRec[i]).attr("id") === $(cbsIncomp[j]).attr("id")) {
                    if (cbsRec[j].checked === true) {
                        $(cbsIncomp[j]).attr('disabled', true);
                    }
                    else {
                        $(cbsIncomp[j]).attr('disabled', false);
                    }
                }
            }
        }
        for (var i = 0; i < cbsIncomp.length; i++) {
            for (var j = 0; j < cbsRec.length; j++) {
                if ($(cbsIncomp[i]).attr("id") === $(cbsRec[j]).attr("id")) {
                    if (cbsIncomp[j].checked === true) {
                        $(cbsRec[j]).attr('disabled', true);
                    }
                    else {
                        $(cbsRec[j]).attr('disabled', false);
                    }
                }
            }
        }



    });
</script>
</html>
