<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

  <link rel="stylesheet" href="/Skeleton/css/skel.css" />
  <link rel="stylesheet" href="/Skeleton/css/style.css" />
  <link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />
<ul>
  <li>
<div>
<img src="/Skeleton/imageDisplay$userId=${visitee.id}" style="height:100px; width:100px"/>
</div>
</li>
<li>
<div>
  <ul>
    <li>
      ${visitee.firstName}
    </li>
    <li>
      ${visitee.lastName}
    </li>
  </ul>
</div>
</li>
</ul>

<div>
  ${visitee.aboutYou}
</div>
<c:forEach items="${visitee.competences}" var="competence">
    <li>
        ${competence.description}
    </li>
</c:forEach>

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
				${day.name} <br>
				${day.dateString}
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
			<c:choose>
				<c:when test="${day.courses[i].available == true}">
					<form action="./application" method="post">
						<input name="courseId" value="${day.courses[i].id}" type="hidden" />
						<input type="submit" value="${course.id}" />
					</form>
				</c:when>
				<c:otherwise>
					<p> that worked </p>
				</c:otherwise>
			</c:choose>
			</td>	
			</c:forEach>
		</tr>
		
	</c:forEach>
</table> 
   
</div>


<c:import url="template/footer.jsp" />
