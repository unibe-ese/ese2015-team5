<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="/Skeleton/js/editSuccess.js"></script>
<ul Style="display: inline-flex">
<li>
<div id="edit-Message"></div>
<form:form method="post" modelAttribute="modifyUserForm" action="./modifyUser" id="modifyUserForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset Style="margin-right: -10em">
        <legend><h1>Edit your information</h1></legend>


        <div>
            <label class="control-label" >Email</label>
                <div class="controls">${user.email}</div>
        </div>

        <div class="control-group">
            <label class="control-label" for="field-enableTut" >I want to offer Tutor-Services <img id="help-picture" height="30px" width="30px" src="img/question.png" title="If you want to be a tutor and offer your services for money you can do this by checking this box. Don't forget to save after!"></label>
            <div class="controls">
                <form:checkbox path="enableTutor" id="field-enableTut" tabindex="1" element="span" title="Check this to become a Tutor for Stutor!"/>
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
                <form:input path="password" type="password" id="field-password" tabindex="3" maxlength="35" placeholder="Password"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="passwordErrors"><form:errors path="passwordControll"/></c:set>
        <div class="control-group<c:if test="${not empty password}"> error</c:if>">
            <label class="control-label" for="field-password">Confirm Password</label>
            <div class="controls">
                <form:input path="passwordControll" type="password" id="field-password" tabindex="4" maxlength="35" placeholder="Confirm Password"/>
                <form:errors path="passwordControll" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <div Style="width:50em">
        	<label class="control-label" for="field-aboutYou">Tell something about yourself</label>
            <textarea id="aboutYou" name="aboutYou" maxlength="999">${user.aboutYou}</textarea>
        </div>
        <div class="form-actions">
            <input type="submit" value="Save Changes" class="btn btn-primary"></input>
        </div>
    </fieldset>
</form:form>
</li>


<li>
	<div style="margin:25px 0px 25px 0;">
		<h1>Change your Profile Picture</h1>
		<img src="/Skeleton/imageDisplay$userId=${user.id}" style="height:100px; width:100px"/>
	</div>
	<form method="POST" action="./changeProfilePic" enctype="multipart/form-data">
	    <input type="file" name="file"/>
	    <input type="submit" value="Upload new Picture">
	</form>
  <c:if test="${not empty pictureError}">
    <div class="error-Message">
      ${pictureError}
    </div>
  </c:if>
</li>
</ul>
