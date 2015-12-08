<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<ul Style="display:inline-flex">
<li>
<div style="display:flex">
<div style="margin: 10px;" class="tabcontent">
	<h1 style="color:white">Contact your Captain</h1>
	<c:forEach items="${tutors}" var="contact">
		<form  method="post" action="./newMessage" id="${contact.id}">
			<input type="hidden" value=${contact.id} name="id"/>
			<input type="submit" value="${contact.firstName} ${contact.lastName}" class btn btn-primary></input>
		</form>
	</c:forEach>
	<h1 style="color:white">Contact your Padawan</h1>
	<c:forEach items="${tutees}" var="contact">
		<form  method="post" action="./newMessage" id="${contact.id}">
			<input type="hidden" value=${contact.id} name="id"/>
			<input type="submit" value="${contact.firstName} ${contact.lastName}" class btn btn-primary></input>
		</form>
	</c:forEach>
	

</div>


<div class="tabbable">
    <ul class="tabs">
        <li><a id="tab1btn" href="#tab1">Received Messages</a></li>
        <li><a id="tab2btn" href="#tab2">Sent Messages</a></li>
    </ul>
    <div class="tabcontent">
  		<div id="tab1" class="tab">
			<c:forEach items="${receivedMessages}" var="msg">
				<div class="message" style="border-bottom: 1px solid white">
					<p>${msg.time}</p>
					<p>From: ${msg.sender.firstName} ${msg.sender.lastName}</p>
					<h1>${msg.title}</h1>
					<p>${msg.message}</p>
				</div>
			</c:forEach>
  		</div>
    	<div id="tab2" class="tab">
    		<c:forEach items="${sentMessages}" var="msg">
				<div class="message" style="border-bottom: 1px solid white">
					<p>${msg.time} <br>
						To: ${msg.recipient.firstName} ${msg.recipient.lastName}</p>
					<h1>${msg.title}</h1>
					<p>${msg.message}</p>
				</div>
			</c:forEach>
    	</div>
    </div>
</div>
</div>
</li>
<li Style="margin-left: 10em">
<div Style="Background: white; text-align: center; border-radius: 10px; width: 10em; padding: 5px">
"Remember: you can only write messages to people you already have an appointment with."
</div>
</li>
<li>
<img Style="width: 15em; margin-left: -3em" src="img/wizzard_messages.png"/>
</li>
</ul>



<c:import url="template/footer.jsp" />
