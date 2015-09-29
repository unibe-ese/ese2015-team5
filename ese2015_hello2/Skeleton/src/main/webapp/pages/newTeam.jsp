<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<form:form action="createTeam" method="post" commandName="teamForm">
    <legend>Team name</legend>
		<form:input path="teamName" />
    <button type="submit" class="btn btn-primary">Create</button>
	
  
</form:form>


<c:import url="template/footer.jsp" />
