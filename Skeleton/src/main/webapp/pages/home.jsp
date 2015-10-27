<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>





<c:import url="template/header.jsp" />


<div>

<h1>Login</h1>
<div id="login-error">${error}</div><form action="./j_spring_security_check" method="post" >
<p>
	<label for="j_username">Username</label>
 	<input id="j_username" name="j_username" type="text" />
</p>
<p>
	<label for="j_password">Password</label>
 	<input id="j_password" name="j_password" type="password" />
</p>
<input  type="submit" value="Login"/> 

</div>

<form:form method="post" modelAttribute="registrationForm" action="registration" id="registrationForm" cssClass="form-horizontal"  autocomplete="off" enctype="multipart/form-data">
    <fieldset>
        <legend>Enter Your Information</legend>

        <c:set var="emailErrors"><form:errors path="email"/></c:set>
        <div class="control-group<c:if test="${not empty emailErrors}">error</c:if>">
            <label class="control-label" for="field-email">Email</label>

            <div class="controls">
                <form:input path="email" id="field-email" tabindex="1" maxlength="45" placeholder="Email"/>
                <form:errors path="email" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="firstNameErrors"><form:errors path="firstName"/></c:set>
        <div class="control-group<c:if test="${not empty firstNameErrors}"> error</c:if>">
            <label class="control-label" for="field-firstName">First Name</label>
            <div class="controls">
                <form:input path="firstName" id="field-firstName" tabindex="2" maxlength="35" placeholder="First Name"/>
                <form:errors path="firstName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="lastNameErrors"><form:errors path="lastName"/></c:set>
        <div class="control-group<c:if test="${not empty lastNameErrors}"> error</c:if>">
            <label class="control-label" for="field-lastName">Last Name</label>
            <div class="controls">
                <form:input path="lastName" id="field-lastName" tabindex="3" maxlength="35" placeholder="Last Name"/>
                <form:errors path="lastName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
        <div class="control-group<c:if test="${not empty password}"> error</c:if>">
            <label class="control-label" for="field-password">Last Name</label>
            <div class="controls">
                <form:input path="password" id="field-password" tabindex="3" maxlength="35" placeholder="Password"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <div class="control-group<c:if test="${not empty file}"> error</c:if>">
        	<label class="control-label" for="field-file">Profile Picture</label>
        	<div class="controls">
        		<input type="file" name="file">
        	</div>
        </div>
        <div class="form-actions">
            <input type="submit" class="btn btn-primary" value="Sign up"></input>
        </div>
    </fieldset>
</form:form>

<div>




<c:import url="template/footer.jsp" />
