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

</div>

<div class="courseTable">
<h1> Schedule </h1>
<button class="btn btn-primary last_week_btn"
                       onclick="location.href='profile/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
<button class="btn btn-primary next_week_btn"
                       onclick="location.href='profile/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>
       
<table>
	<tr>
		<th>
			Time
		</th>
	
		<c:forEach items="${week.weekDays}" var="day">
			<th>
				<p>${day.name} <br>
				${day.dateString}</p>
			</th>
		</c:forEach>
	</tr>
	<c:forEach var="i" begin="0" end="23">
		<tr>
			<td>
				${hours[i]}
			</td>
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

