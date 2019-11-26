<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="content row">
    <div class="col-md-6">
        <div class="row">
            <div class="form-group col-md-4">
                <label for="compCode" class="col-form-label">Company Code *</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="compCode">
                    <form:input path="compCode"  class="form-control"
                                id="compCode" placeholder="Company Code"
                                onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" maxlength="3"/>
                    <c:if test="${status.error}">
						<span class="text-danger">
						<form:errors path="compCode" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="companyName" class="col-form-label">Company Name *</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="companyName">
                    <form:input path="companyName"  class="form-control"
                                id="companyName" placeholder="Company Name" />
                    <c:if test="${status.error}">
												<span class="text-danger">
													<form:errors path="companyName" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="compRegNo" class="col-form-label">Company Reg. No</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="compRegNo">
                    <form:input path="compRegNo"  class="form-control"
                                id="compRegNo" placeholder="Company Reg. No" />
                    <c:if test="${status.error}">
												<span class="text-danger">
													<form:errors path="compRegNo" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-4">
                <label for="activeDate" class="col-form-label">Active Date *</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="activeDate">
                    <form:input path="activeDate"  data-format="YYYY-MM-DD HH:mm:ss"
                                class="form-control"
                                id="activeDate" placeholder="Active Date" />
                    <c:if test="${status.error}">
												<span class="text-danger">
													<form:errors path="activeDate" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>
    </div>

    <div class="col-md-6">
        <div class="row">
            <div class="form-group col-md-4">
                <label for="compCodeHRIS" class="col-form-label">Company Code HRIS *</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="compCodeHRIS">
                    <form:input path="compCodeHRIS"  class="form-control"
                                id="compCodeHRIS" placeholder="Company Code HRIS"
                                onkeyup="this.value=this.value.replace(/[^A-Z]/g,'');" maxlength="3"/>
                    <c:if test="${status.error}">
												<span class="text-danger">
													<form:errors path="compCodeHRIS" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="companyAbbrName" class="col-form-label">Company Abbr Name *</label>
            </div>
            <div class="form-group col-md-8">
                <spring:bind path="companyAbbrName">
                    <form:input path="companyAbbrName"  class="form-control"
                                id="companyAbbrName" placeholder="Company Abbr Name"  maxlength="3"/>
                    <c:if test="${status.error}">
												<span class="text-danger">
													<form:errors path="companyAbbrName" cssClass="text-danger"/> </span>
                    </c:if>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="logoFile" class="col-form-label">Company Logo *</label>
            </div>
            <div class="form-group col-md-8">
                <div class="customFile"
                     data-controlMsg="Choose a company logo image(jpg/png) file">
                    <span class="selectedFile">No file selected</span> <input
                        type="file" name="logoFile"
                        class="imageFile" id="logoFile" accept="image/*">
                </div>
            </div>
        </div>
    </div>
</div>