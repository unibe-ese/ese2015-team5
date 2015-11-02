<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Homepage</h1>

<form:form action="searchCompetence">
    <input type="text" name="searchName"/>
    <input type="submit" value="Search"></input>
</form:form>


<c:import url="template/footer.jsp" />
