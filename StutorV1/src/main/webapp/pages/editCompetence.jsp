<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<link rel="stylesheet" href="/Skeleton/css/skel.css" />
<link rel="stylesheet" href="/Skeleton/css/style.css" />
<link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />

<c:import url="template/header.jsp" />


Editing Competence: <b>Description: ${editCompetenceForm.description}</b>
ID of Form: ${editCompetenceForm.compReferenceId}
ID of Comp: ${competence.id}



<form:form method="post" modelAttribute="editCompetenceForm" action="/Skeleton/profile/editComp/${competence.id}">
    <form:input type="text" path="description" value="${competence.description}"/>
    <form:errors path="description" cssClass="help-inline" element="span"/>



<%-- <table class="calendar">
    <c:forEach items="${editCompetenceForm.availabilities}" var="availability" varStatus="statusI">
        ${availability.available}
        <form:checkbox path="availability.available"/>

    </c:forEach>
</table> --%>


<input type="Submit" value="Edit!"></input>
</form:form>


<c:import url="template/footer.jsp" />
