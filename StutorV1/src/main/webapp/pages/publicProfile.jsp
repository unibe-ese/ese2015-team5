<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<c:import url="template/header.jsp" />

<script src="/Skeleton/js/color.js"></script>

<link rel="stylesheet" href="/Skeleton/css/skel.css" />
<link rel="stylesheet" href="/Skeleton/css/style.css" />
<link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />


<div class="tabbable">
    <ul class="tabs">
        <li><a id="tab1btn" href="#tab1">Personal Information</a></li>
        <li><a id="tab2btn" href="#tab2">This Tutors Competences</a></li>
    </ul>
    <div class="tabcontent">
		<div id="tab1" class="tab">

			<c:if test="${not empty pageSuccess}">
    			<div class="success-Message">
      				${pageSuccess}
   				</div>
  			</c:if>
			<c:if test="${not empty pageError}">
		  		<div class="error-Message">
		   			${pageError}
		    	</div>
			</c:if>
			<div>
				<div Style="margin-bottom: -2px; margin-left: 10px;">
					<h1 Style="color:#FFC878; text-shadow: 1px 1px grey; font-size: 45px">${visitee.firstName}
					${visitee.lastName}</h1>
				</div>
				<ul Style="display: inline-flex; border-radius: 10px; background: linear-gradient(to top, #B0CDEA, #DBEAF9)">
					<li><img src="/Skeleton/imageDisplay$userId=${visitee.id}"style="height:100px; width:100px; margin: 1em 3em 0em 1em"/></li>

					<li Style="margin-top: 1em; margin-right:3em">
						<div Style="border-radius: 5px; text-align: justify">
							<div Style="margin: 0em 1em 0em 1em">
								<h1>Description</h1>
								${visitee.aboutYou}
							</div>
						</div>
					</li>
				</ul>
			</div>


			<h1 Style="margin-top: 40px"> Schedule </h1>
			<div Style="margin-bottom: 20px">Here you can book an appointment with the tutor you are currently inspecting. When you click on a field that is marked with "free"
			the tutor will get a request which he can either accept or decline. If he accepts we will save the date in the "rendez vous" list
			on the <a href="/Skeleton/">main page</a>. You can also check out the tutors other competences in the second tab.</div>
			<div class="courseTable">

			<button class="btn btn-primary last_week_btn"
								onclick="location.href='/Skeleton/tutorProfile/${visitee.id}/lastWeek/${week.weekDays[0].dateString}/'">Last Week</button>
			<button class="btn btn-primary next_week_btn"
								onclick="location.href='/Skeleton/tutorProfile/${visitee.id}/nextWeek/${week.weekDays[0].dateString}/'">Next Week</button>

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
        </div> <!-- tab1 close div -->

        <div id="tab2" class="tab">
			<h1>This tutors competences</h1>
			<ul>
				<c:forEach items="${visitee.competences}" var="competence">
					<li Style="margin-top: 1em; margin-left: 2em; background: linear-gradient(to left, #5A86B0, #B0CDEA); border-radius: 10px; width: 30%">${competence.description}(${competence.grade})</li>
				</c:forEach>
			</ul>
        </div>
    </div>
</div>





<c:import url="template/footer.jsp" />
