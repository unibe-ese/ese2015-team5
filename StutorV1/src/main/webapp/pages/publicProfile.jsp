<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<c:import url="template/header.jsp" />

<script src="/Skeleton/js/color.js"></script>

<link rel="stylesheet" href="/Skeleton/css/skel.css" />
<link rel="stylesheet" href="/Skeleton/css/style.css" />
<link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />

<div Style="border: 2px solid white; border-radius: 10px; background: #B0CDEA; padding:10px;">

	<div>
		<ul Style="display: inline-flex;">
			<li><img src="/Skeleton/imageDisplay$userId=${visitee.id}"style="height:100px; width:100px; margin-right: 3em"/></li>
			<li Style="margin: 1em 3em 0 0; width: 10em">
				<div Style="background: linear-gradient(to top, #B0CDEA, #DBEAF9); border-radius: 5px; text-align: center">
					${visitee.firstName}
					${visitee.lastName}
				</div>
			</li>
			<li Style="margin-top: 1em; margin-right:3em">
				<div Style="background: linear-gradient(to top, #B0CDEA, #DBEAF9); border-radius: 5px; text-align: justify">
					<div Style="margin: 0em 1em 0em 1em">
						${visitee.aboutYou}
					</div>
				</div>
			</li>
		</ul>
	</div>
	<div>
		<ul>
			<c:forEach items="${visitee.competences}" var="competence">
				<li Style="margin-top: 1em; margin-left: 2em; background: linear-gradient(to left, #5A86B0, #DBEAF9); border-radius: 10px; width: 20%">${competence.description}</li>
			</c:forEach>
		<ul>
	<div>
	<div class="courseTable">
	<h1> Schedule </h1>
	<button class="btn btn-primary last_week_btn"
						onclick="location.href='/Skeleton/profile/${visitee.id}/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
	<button class="btn btn-primary next_week_btn"
						onclick="location.href='/Skeleton/profile/${visitee.id}/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>

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
							<input type="submit" value="${day.courses[i].description}" class="tableBtn table" />
						</form>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				</td>
				</c:forEach>
			</tr>

		</c:forEach>
	</table>
	</div>

</div>

<c:import url="template/footer.jsp" />
