<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Search for your courses:</h1>
<form action="/Skeleton/findCompetenceLike"  commandName="searchQuery" method="get">
    <input type="text" name="searchQuery" path="searchQuery"/>
    <input type="submit" value="Search"></input>
</form>
<table>
    <c:forEach items="${competences}" var="competence">
        <tr>
            <td>
                ${competence.description}
            </td>
        </tr>
    </c:forEach>
</table>

<c:import url="template/footer.jsp" />
