<%@ page import="com.siroi.assignment.util.SiroiAssignmentHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <c:if test="${listResponse.totalElement == 0}">
        <div class="header">
            <p  class="title">No Task found!</p>
        </div>
    </c:if>
    <c:if test="${listResponse.totalElement > 0}">
        <table class="table table-hover table-striped table-sm" data-total="${listResponse.totalElement}">
        <thead>
        <tr>
            <th id="compCode" class="th-pointer" onclick="sortTable(this, 'company-table')" data-order="">Company Code<div></div></th>
            <th id="companyName" class="th-pointer" onclick="sortTable(this, 'company-table')" data-order="">Company Name<div></div></th>
            <th id="lastModifiedOn" class="th-pointer" onclick="sortTable(this, 'company-table')" data-order="">Last Modified On<div></div></th>
            <th id="lastModifiedBy" class="th-pointer" onclick="sortTable(this, 'company-table')" data-order="">Last Modified By<div></div></th>
            <th>Action<div></div></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listResponse.data}" var="company">
            <tr>
                <fmt:parseDate value="${ company.lastModifiedOn }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />

                <td> ${company.compCode}</td>
                <td> ${company.companyName} </td>
                <td>  <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" />  </td>
                <td> ${company.lastModifiedBy} </td>
                <td>
                    <a href="${context}/company/view/${company.compCode}" class="btn btn-danger btn-fill ">
                        <i class="pe-7s-file">View</i></a>
                    <a href="${context}/company/edit/${company.compCode}" class="btn btn-danger btn-fill ">
                        <i class="pe-7s-settings">Edit</i></a>
                    <a href="javascript:void(0)"  class="btn btn-danger btn-fill"
                       onclick="deleteCompany('${context}/company/delete/${company.compCode}', '${company.compCode}')">
                        <i class="pe-7s-close">Delete</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </c:if>
</div>


