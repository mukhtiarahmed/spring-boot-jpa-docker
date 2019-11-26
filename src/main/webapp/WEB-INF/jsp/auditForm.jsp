<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="content row">
    <div class="col-md-6">
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="isActive" class="col-form-label">Status *</label>
                </div>
                <div class="form-group col-md-8">
                        <form:select path="isActive"  class="form-control form-control-lg">
                            <form:option value="true">Active</form:option>
                            <form:option value="false">DeActive</form:option>
                        </form:select>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="createdBy" class="col-form-label">Created By</label>
                </div>
                <div class="form-group col-md-8">
                    <form:input path="createdBy"  readonly="true"  class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="lastModifiedBy" class="col-form-label">Updated By</label>
                </div>
                <div class="form-group col-md-8">
                    <form:input path="lastModifiedBy"  readonly="true"  class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="deactivatedBy" class="col-form-label">Deactivated By</label>
                </div>
                <div class="form-group col-md-8">
                    <form:input path="deactivatedBy"  readonly="true"  class="form-control" />
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="reactivatedBy" class="col-form-label">Reactivated By</label>
                </div>
                <div class="form-group col-md-8">
                    <form:input path="reactivatedBy"  readonly="true"  class="form-control" />
                </div>
            </div>

        </div>


    <div class="col-md-6">
        <div class="row">
            <div class="form-group col-md-12">
                <input type="text" disabled readonly class="form-control" style="visibility: hidden">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="createdOn" class="col-form-label">Created On</label>
            </div>
            <div class="form-group col-md-8">
                <form:input path="createdOn"  readonly="true"  class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="lastModifiedOn" class="col-form-label">Updated ON</label>
            </div>
            <div class="form-group col-md-8">
                <form:input path="lastModifiedOn"  readonly="true"  class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="deactivatedOn" class="col-form-label">Deactivated On</label>
            </div>
            <div class="form-group col-md-8">
                <form:input path="deactivatedOn"  readonly="true"  class="form-control" />
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="reactivatedOn" class="col-form-label">Reactivated On</label>
            </div>
            <div class="form-group col-md-8">
                <form:input path="reactivatedOn"  readonly="true"  class="form-control" />
            </div>
        </div>
    </div>
</div>