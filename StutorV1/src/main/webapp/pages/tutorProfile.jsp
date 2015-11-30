<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/Skeleton/js/color.js"></script>

<div>
	<div class="houerlyRate-container">
	<form action="./profile/houerlyRate" method="post">
		<label for="houerlyRate">$$$$$$$$ / hour</label>
	  <input name="houerlyRate" value="${user.houerlyRate}" type="text" style="display:inline">
		<c:if test="${not empty houerlyError}">
			<label class="error-label" for="field-houerlyRate">${houerlyError}</label>
		</c:if>
	  <input type="submit" value="GO"/>
	</form>
	</div>
<form:form method="post" modelAttribute="addCompetenceForm" action="./addCompetence" id="addComp">
  <div>
		<label for="houerlyRate">Add your tutoring Subjects</label>
    <form:input type="text" path="description"/>
    <form:errors path="description" cssClass="help-inline" element="span"/>
  </div>
  <input type="submit" value="Add new Subject"></input>
</form:form>

<table class="competenceList">
    <c:forEach items="${user.competences}" var="competence">
        <tr class="competence-List-Entry">
            <td class="competence-List-Description">
                ${competence.description}
            </td>
						<td class="competence-List-Gradeform">
								<form action="/Skeleton/profile/setGradeForCompetence/${competence.id}" method="post">
									<label class="form-label-align" for="competenceGrade">Grade</label>
									<input class="form-input-align" type="text" name="competenceGrade" value="${competence.grade}"/>
									<input class="form-button-align" type="submit" value="GO"/>
								</form>
						</td>
            <td class="competence-List-Delete">
                <form:form action="profile/deleteComp/${competence.id}" method="get">
                    <input type="submit" value="X"></input>
                </form:form>
            </td>

        </tr>
    </c:forEach>
</table>

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
