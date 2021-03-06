<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/Skeleton/js/color.js"></script>

<div>
	<ul Style="display:inline-flex">
	<li>
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
                <label>Tutoring Course:</label>  <b>${competence.description}</b>
            </td>
       			<td class="competence-List-Grade">
								<label>Grade:</label>  <b>${competence.grade}</b>
						</td>
            <td class="competence-List-Delete">
                <form:form action="tutorProfile/deleteComp/${competence.id}" method="get">
                    <input type="submit" value="X"></input>
                </form:form>
            </td>
        </tr>
    </c:forEach>
	</table>
	</li>
	
	<li>
	<div class="houerlyRate-container">
		<form action="./tutorProfile/houerlyRate" method="post">
			<label for="houerlyRate">Hourly Rate $/h  <img id="help-picture" height="30px" width="30px" src="img/question.png" title="Enter the amount of Swiss Franks you want to be compensated with for your efforts. Your rate applies to all your tutoring subjects"></label>
			<input name="houerlyRate" value="${user.houerlyRate}" type="text" style="display:inline" />
			<c:if test="${not empty houerlyError}">
			<div class="error-label, help-inline" for="field-houerlyRate">${houerlyError}</div>
			</c:if>
	  		<input type="submit" value="Save Hourly Rate"/>
		</form>
	</div>
	</li>
	
	</ul>


	<hr>

	<div class="courseTableDescription">
		<h1> Calendar </h1>
		This is your calendar, click time-slots to make them available to students who want to book a lesson with you.
		If you don't click any slots nobody can choose you. Once a student has chosen a particular time-slot you will 
		be shown his/her apply on your main search page. You can accept and get your pay for a one hour lesson, or decline 
		and go empty.
	</div>

	<div class="courseTable">
		
		
		
		<button class="btn btn-primary last_week_btn"
                       onclick="location.href='tutorProfile/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
		<button class="btn btn-primary next_week_btn"
                       onclick="location.href='tutorProfile/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>

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
