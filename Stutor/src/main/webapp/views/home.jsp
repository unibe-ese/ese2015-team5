<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Greetings, this is a value from the controller: <c:out value="${value}"/></p>
        
       <form:form method="post" modelAttribute="loginForm" action="" id="loginForm" cssClass="form-horizontal"  autocomplete="on">
    		<fieldset>
        		<div class="control-group<c:if test="${not empty emailErrors}"> error</c:if>">
            		<label class="control-label" for="field-email">Email</label>

            		<div class="controls">
                		<form:input path="email" id="field-email" tabindex="1" maxlength="45" placeholder="Email"/>
            		</div>
        		</div>
       
        		<div class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>">
            		<label class="control-label" for="field-password">Password</label>
            		<div class="controls">
                		<form:input path="password" id="field-firstName" tabindex="2" maxlength="35" placeholder=""/>
            		</div>
        		</div>
        
<<<<<<< HEAD
        		<div class="form-actions">
            		<button type="submit">Login</button>
        		</div>
    		</fieldset>
		</form:form>
        
=======
        
        

>>>>>>> Stutor
    </body>
</html>
