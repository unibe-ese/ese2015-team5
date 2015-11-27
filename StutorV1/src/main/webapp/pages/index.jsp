<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>Search for your courses:</h1>
<form action="/Skeleton/findCompetenceLike"  commandName="searchQuery" method="get" Style="width: 50em; display:inline-flex">
    <input type="text" name="searchQuery" path="searchQuery"/>
    <input type="submit" value="Search" Style="height: 1.7em"></input>
</form>
<table>
    <c:forEach items="${competences}" var="competence">
        <tr>
            <td>
                ${competence.description}
                <button class="btn btn-primary"
                                       onclick="location.href='profile/${competence.owner.id}'">Visit</button>
            </td>
        </tr>
    </c:forEach>
    <h1>Applications:</h1>
    <c:forEach items="${applications}" var="application">
        <tr>
            <td>
                ${application.master.firstName}
                ${application.slave.firstName}
                <button onclick="location.href='./accept/${application.id}'">Accept</button>
                <button onclick="location.href='./decline/${application.id}'">Decline</button>
            </td>
        </tr>
    </c:forEach>
</table>
<input type="text" id="searchQuery"/>
<button type="button"onclick="ajaxTest()">Search</button>

<p id="demo"></p>

<c:import url="template/footer.jsp" />
