<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1>Add your Tutoring Subjects</h1>
<table class="competenceList">
    <c:forEach items="${user.competences}" var="competence">
        <tr>
            <td>
                ${competence.description}
            </td>
            <td>
                <form:form action="profile/deleteComp/${competence.id}" method="get">
                    <input type="submit" value="X"></input>
                </form:form>
                 <button class="btn btn-primary"
                                        onclick="location.href='profile/editComp/${competence.id}'">Update</button>
            </td>

        </tr>
    </c:forEach>
</table>
</div>
<form:form method="post" modelAttribute="addCompetenceForm" action="./addCompetence" id="addComp">

  <div>
    <form:input type="text" path="description"/>
    <form:errors path="description" cssClass="help-inline" element="span"/>
  </div>
  <input type="submit" value="Add new Subject"></input>
</form:form>
