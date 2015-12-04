<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />
       		<div class="tabbable">
       		<form:form method="post" modelAttribute="messageForm" action="./sendMessage" id="messageForm"  autocomplete="off">
       			<h1>To : ${messageForm.recipient.firstName} ${messageForm.recipient.lastName}</h1>
       			<label>Titel</label>
				<form:hidden path="userId" id="field-recipient" value="${messageForm.recipient.id}"/>
       			<form:input path="title" id="field-title" maxlength="35"/>
       			<label>Message</label>
       			<textarea id="message" name="message" maxlength="500"></textarea>
       			<input type="submit" value="Send" class="btn btn-primary"></input>
       		
       		</form:form>
       		</div>
     

<c:import url="template/footer.jsp" />
