<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div style="float:left; width: 200px; height:200px;s background-color: white; margin: 10px;">
	<c:forEach items="${contacts}" var="contact">
		<p>${contact.email}</p>
	</c:forEach>

</div>


<div class="tabbable" style="float:right">
    <ul class="tabs">
        <li><a id="tab1btn" href="#tab1">Received Messages</a></li>
        <li><a id="tab2btn" href="#tab2">Sent Messages</a></li>
        <li><a id="tab3btn" href="#tab3">New Message</a></li>
    </ul>
    <div class="tabcontent">
  		<div id="tab1" class="tab">
			<c:forEach items="${receivedMessages}" var="msg">
				<div class="message">
					<h1>${msg.title}</h1>
					<p>${msg.message}</p>
				</div>
			</c:forEach>
  		</div>
    	<div id="tab2" class="tab">
    		<c:forEach items="${sentMessages}" var="msg">
				<div class="message">
					<h1>${msg.title}</h1>
					<p>${msg.message}</p>
				</div>
			</c:forEach>
    	</div>
       	<div id="tab3" class="tab">
       		<div>
       			
       		</div>
       		<div>
       		<form:form method="post" modelAttribute="messageForm" action="./sendMessage" id="messageForm"  autocomplete="off">
       			<label>To</label>
       			<form:input path="recipient" id="field-recipient" maxLength="35" placeholder=""/>
       			<label>Titel</label>
       			<form:input path="title" value="${messageForm.recipient}" id="field-title" maxlength="35"/>
       			<label>Message</label>
       			<textarea id="message" name="message" maxlength="500"></textarea>
       			
       			<input type="submit" value="Send" class="btn btn-primary"></input>
       		
       		</form:form>
       		</div>
       		
       	</div>
    </div>
</div>

<c:import url="template/footer.jsp" />
