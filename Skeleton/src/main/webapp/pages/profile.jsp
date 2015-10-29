<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />
<form:form method="post" modelAttribute="modifyUserForm" action="./modifyUser" id="modifyUserForm" cssClass="form-horizontal"  autocomplete="off" style="width:500px">
    <fieldset>
        <legend><h1>Edit your information</h1></legend>
        <c:if test="${not empty error}">
           Error: ${error}
        </c:if>

        <div>
            <label class="control-label" >Email</label>
                <div class="controls">
                  ${user.email}
                </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="field-firstName">Enable Tutor</label>
            <div class="controls">
                <form:checkbox path="enableTutor" id="field-enableTut" tabindex="1" value="${user.enableTutor}"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="field-firstName">First Name</label>
            <div class="controls">
                <form:input path="firstName" id="field-firstName" tabindex="2" maxlength="35" value="${user.firstName}"/>
                <form:errors path="firstName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="lastNameErrors"><form:errors path="lastName"/></c:set>
        <div class="control-group<c:if test="${not empty lastNameErrors}"> error</c:if>">
            <label class="control-label" for="field-lastName">Last Name</label>
            <div class="controls">
                <form:input path="lastName" id="field-lastName" tabindex="3" maxlength="35" value="${user.lastName}"/>
                <form:errors path="lastName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
        <div class="control-group<c:if test="${not empty password}"> error</c:if>">
            <label class="control-label" for="field-password">Password</label>
            <div class="controls">
                <form:input path="password" type="password" id="field-password" tabindex="3" maxlength="35" value="${user.password}"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="passwordErrors"><form:errors path="passwordControll"/></c:set>
        <div class="control-group<c:if test="${not empty password}"> error</c:if>">
            <label class="control-label" for="field-password">Again Please</label>
            <div class="controls">
                <form:input path="passwordControll" type="password" id="field-password" tabindex="4" maxlength="35" value="${user.password}"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <div class="form-actions">
            <input type="submit" value="Edit" class="btn btn-primary"></input>
        </div>
    </fieldset>
</form:form>

<table>
    <c:forEach items="${user.competences}" var="competence">
        <tr>
            <td>
                ${competence.description}
            </td>
            <td>
                <form:form action="profile/delete$id=${competence.id}">
                    <input type="submit" value="Delete"></input>
                </form:form>
            </td>

        </tr>
    </c:forEach>
</table>




<c:import url="template/footer.jsp" />
