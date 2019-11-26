<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="title" value="View  Company Master  ( ${comany.companyName} )" scope="request" />
<html>
<head>

        <jsp:include page="head.jsp">
            <jsp:param name="title"  value="${title}" />
        </jsp:include>

</head>
<body>

<div class="wrapper">
    <%@include file="sidebar.jsp" %>

    <div class="main-panel ps ps--active-y">
        <%@include file="navbar.jsp" %>

        <div class="main-content">
            <div class="card">

                <div class="content row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label class="col-form-label">Company Name</label>
                                <h4 class="title">${company.companyName}</h4>
                            </div>
                            <div class="form-group col-md-4 pull-right">
                                <div class="row">
                                    <a href="${context}/company/edit/${company.compCode}"
                                       class="btn btn-fill btn-danger">Edit</a>
                                    <a href="${context}/company/list" class="btn btn-fill btn-primary">Back</a>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Code</label>
                                <p class="title">${company.compCode}</p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Code HRIS</label>
                                <p class="title">${company.compCodeHRIS}</p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Abbr Name</label>
                                <p class="title">${company.companyAbbrName}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Reg. No</label>
                                <p class="title">${company.compRegNo}</p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Active Date</label>
                                <fmt:parseDate value="${ company.activeDate }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                <p class="title"> <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" /></p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Status</label>
                                <p class="title">${company.isActive}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Created By</label>
                                <p class="title">${company.createdBy}</p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Created On</label>
                                <fmt:parseDate value="${ company.createdOn }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                <p class="title"> <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" /></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Updated By</label>
                                <p class="title">${company.lastModifiedBy}</p>
                            </div>
                            <div class="form-group col-md-4">
                                <label class="col-form-label">Company Updated On</label>
                                <fmt:parseDate value="${ company.lastModifiedOn}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                <p class="title"> <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" /></p>
                            </div>
                        </div>
                        <c:if test="${!empty company.deactivatedBy}">
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label class="col-form-label">Company Deactived By</label>
                                    <p class="title">${company.deactivatedBy}</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="col-form-label">Company Deactived On</label>
                                    <fmt:parseDate value="${ company.deactivatedOn}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                    <p class="title"> <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" /></p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${!empty company.reactivatedOn}">
                            <div class="row">
                                <div class="form-group col-md-4">
                                    <label class="col-form-label">Company Reactived By</label>
                                    <p class="title">${company.reactivatedBy}</p>
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="col-form-label">Company Reactived On</label>
                                    <fmt:parseDate value="${ company.reactivatedOn}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                                    <p class="title"> <fmt:formatDate pattern="EEEE, MMM dd, yyyy HH:mm:ss a" value="${ parsedDateTime }" /></p>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${!empty company.companyLogo}">
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label  class="col-form-label"> Company Logo</label>
                            </div>
                            <div class="form-group col-md-8">
                                <div class="previewContainer">
                                    <img class="img-rounded" src="${context}/company/logo/${company.compCode}/${company.companyLogo}"
                                         alt="Image preview..." width="200" height="200" />
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </div>


                </div>

                <div></div>
            </div>

        </div>
    </div>
</div>
</body>

</html>
