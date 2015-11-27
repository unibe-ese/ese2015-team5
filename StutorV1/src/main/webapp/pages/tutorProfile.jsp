<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/Skeleton/js/color.js"></script>

<div>
	<label class="control-label" for="field-aboutYou">Tell something about yourself</label>
    <textarea id="aboutYou" name="aboutYou" maxlength="500">${user.aboutYou}</textarea>
</div>
<div>
<h1>Add your Tutoring Subjects</h1>

<form action="./profile/houerlyRate" method="post">
  <input name="houerlyRate" value="${user.houerlyRate}" type="text"/>
  <input type="submit" value="GO"/>
</form>


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

<button class="btn btn-primary"
                       onclick="location.href='profile/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
<button class="btn btn-primary"
                       onclick="location.href='profile/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>
                       
<table id="tutorTable">
<thead>
  <tr>
    <c:forEach items="${week.weekDays}" var="day">
      <th>
        ${day.name}
        ${day.dateString}
      </th>
    </c:forEach>
  </tr>
 </thead>
 <tbody>
  <tr>
  	<c:forEach items="${week.weekDays}" var="day">
    	<td>
          <c:forEach items="${day.courses}" var="course">
            <div>
              <form:form modelAttribute="addCourseForm" action="./addCourse">
                 <form:hidden path="slot" value="${course.slot}"/>
                 <form:hidden path="dateString" value="${day.dateString}" />
                 <input type="submit" value="${course.description}" class="table"/>
              </form:form>
            </div>
          </c:forEach>
        </td>
    </c:forEach>
  </tr>
</tbody>
</table>
</div>
