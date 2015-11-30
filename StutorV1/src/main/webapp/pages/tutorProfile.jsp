<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/Skeleton/js/color.js"></script>

<div>
	<div class="houerlyRate-container">
	<form action="./profile/houerlyRate" method="post">
		<label for="houerlyRate">Hourly Rate $/h  <img id="help-picture" height="30px" width="30px" src="img/question.png" title="Enter the amount of Swiss Franks you want to be compensated with for your efforts. Your rate applies to all your tutoring subjects"></label>
	  <input name="houerlyRate" value="${user.houerlyRate}" type="text" style="display:inline">
		<c:if test="${not empty houerlyError}">
			<label class="error-label" for="field-houerlyRate">${houerlyError}</label>
		</c:if>
	  <input type="submit" value="Save"/>
	</form>
	</div>
<form:form method="post" modelAttribute="addCompetenceForm" action="./addCompetence" id="addComp">
  <div>
<<<<<<< HEAD
		<label for="houerlyRate">Add your tutoring Subjects</label>
=======
		<label for="houerlyRate">Add your tutoring Subjects  <img id="help-picture" height="30px" width="30px" src="img/question.png" title="Add subjects in which you feel like you can tuter other students. You can create a new subject or choose existing ones that appear when you type into the field below. Add your grade after."></label>
>>>>>>> 78e6dd79bd5259d0918d0e7da251ad1fb3d99508
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
<label><b>Offer possible tutoring time slots</b><img id="help-picture" height="30px" width="30px" src="img/question.png" title="In time table you can offer hourly slots to every full hour.Click on the vertically listed slots to display your availability"></label>
<button class="btn btn-primary" 
		Style="height:2em;"
		onclick="location.href='profile/lastWeek/${week.weekDays[0].dateString}/'">Previous Week</button>

<button class="btn btn-primary"
                       onclick="location.href='profile/nextWeek/${week.weekDays[0].dateString}/'"
                       Style="height:2em;">Next Week</button>

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
