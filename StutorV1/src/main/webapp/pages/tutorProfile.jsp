<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/Skeleton/js/color.js"></script>

<div>

	<div class="houerlyRate-container">
		<form action="./profile/houerlyRate" method="post">
			<label for="houerlyRate">Hourly Rate $/h  <img id="help-picture" height="30px" width="30px" src="img/question.png" title="Enter the amount of Swiss Franks you want to be compensated with for your efforts. Your rate applies to all your tutoring subjects"></label>
			<input name="houerlyRate" value="${user.houerlyRate}" type="text" style="display:inline" />
			<c:if test="${not empty houerlyError}">
			<label class="error-label" for="field-houerlyRate">${houerlyError}</label>
			</c:if>
	  		<input type="submit" value="Save"/>
		</form>
	</div>

	<form:form method="post" modelAttribute="addCompetenceForm" action="./addCompetence" id="addComp">
  		<div>
				<label for="description">Add your tutoring Subjects  <img id="help-picture" height="30px" width="30px" src="img/question.png" title="Add subjects in which you feel like you can tuter other students. You can create a new subject or choose existing ones that appear when you type into the field below. Add your grade after."></label>
    		<form:input type="text" path="description"/>
    		<form:errors path="description" cssClass="help-inline" element="span"/>
  		</div>
			<div>
				<label for="Grade">Grade<img id="help-picture" height="30px" width="30px" src="img/question.png" title="Add subjects in which you feel like you can tuter other students. You can create a new subject or choose existing ones that appear when you type into the field below. Add your grade after."></label>
	    	<form:input type="text" path="grade"/>
	    	<form:errors path="grade" cssClass="help-inline" element="span"/>
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
					<input class="form-button-align" type="submit" value="Save Grade"/>
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

	<div class="courseTable">
		<h1> Schedule </h1>
		<button class="btn btn-primary last_week_btn"
                       onclick="location.href='profile/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
		<button class="btn btn-primary next_week_btn"
                       onclick="location.href='profile/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>

		<table>
		<tr>
			<th>Time</th>
			<c:forEach items="${week.weekDays}" var="day">

			<th>${day.name} <br>${day.dateString}</th>
			</c:forEach>
		</tr>
		<c:forEach var="i" begin="0" end="23">
		<tr>
			<td>${hours[i]}</td>
			<c:forEach items="${week.weekDays}" var="day">
			<td>
				<form:form modelAttribute="addCourseForm" action="./addCourse">
					<form:hidden path="slot" value="${day.courses[i].slot}" />
					<form:hidden path="dateString" value="${day.dateString}" />
					<input type="submit" value="${day.courses[i].description}" class="tableBtn table" />
				</form:form>
			</td>
			</c:forEach>
		</tr>

		</c:forEach>
		</table>

	</div>
</div>
