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
        
        
        
        
        
        <form:form method="post" commandName="createUser">
        	<form:input type="text">
  			<br>
  			<input type="submit" align="center" value="Execute">
		</form:form>
    </body>
</html>
