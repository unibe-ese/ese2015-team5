<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<h1>User Information</h1>
<table>
	


       
	        	<th>First Name: <c:out value="${user.firstName}"/></th>
			  	<th>Last Name: <c:out value="${user.lastName}"/></th>
	          	<th>Email: <c:out value="${user.email}"/></th> 
				<th>ID <c:out value="${user.id}"/></th>	
		

	
</table>





<c:import url="template/footer.jsp" />