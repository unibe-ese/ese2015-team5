<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<ul Style="display: inline-flex">
<li Style="width: 20em; margin-right: 10em">

<h1>Sign Up Here!</h1>

<form:form method="post" modelAttribute="signupForm" action="register" id="signupForm" cssClass="form-horizontal"  autocomplete="off" enctype="multipart/form-data">
    <fieldset>
        <legend>Enter Your Information and upload a picture</legend>

		<ul Style="display: inline-flex">
		<li Style="margin-right: 50em">
		    <c:set var="emailErrors"><form:errors path="email"/></c:set>
	        <div class="control-group<c:if test="${not empty emailErrors}"> error</c:if>">
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
	            <label class="control-label" for="field-password">Password</label>
	            <div class="controls">
	                <form:input path="password" id="field-password" tabindex="3" maxlength="35" placeholder="Password"/>
	                <form:errors path="password" cssClass="help-inline" element="span"/>
	            </div>
	        </div>
	        <div>
	          <form:input type="file" path="profilePic"/>
	          <c:if test="${not empty pictureError}">
	             <div class="help-inline">
	             ${pictureError}
	          	 </div>
	          </c:if>
	        </div>
	        <input type="submit" value="Sign up"/>
	        <a href="/Skeleton/login"> <input type="button" value="Cancel"/> </a>
        </li>

        <li>

        </li>
        </ul>

    </fieldset>
</form:form>
</li>
<li Style="width: 20em; margin-top: 10em">
<img src="img/wizard no background.gif"/>
</li>
<li Style="margin-top:10em">
<div Style="Background: white; border-radius: 10px; width: 15em">
Take care! The register-magister is watching you. Remember to
fill out all text areas and to upload a profile picture.<br>
Registrus Maximus
</div>
</li>
</ul>



	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>


<c:import url="template/footer.jsp" />
