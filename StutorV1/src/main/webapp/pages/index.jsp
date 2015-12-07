<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<ul Style="display: inline-flex">
	<li>
		<div class="newsfeed">
			<h1 Style="text-shadow: none; margin-left:1em; color: white; text-decoration:underline;">Rendez Vous</h1>
         		<ul class="newsEntryElement">
         			<c:forEach items="${newsfeed}" var="news">		
	         			<li style="border-bottom:1px solid white; padding-bottom: 5px">
	              			<c:if test="${news.tutorCourse == true}">Course</c:if>
	              			<c:if test="${news.tutorCourse == false}">Lesson</c:if>
							<br>
							${news.dateRepresentation} 
							<br>
							${news.partner.firstName}
	                		${news.partner.lastName}
	              		</li>
              		</c:forEach>
              		</ul>
              		<h1  Style="text-shadow: none; margin-left:1em; color:white; text-decoration: underline;">Pending</h1>
						<ul class="newsEntryElement">
					  	<c:forEach items="${applications}" var="application">
						<li Style="border-bottom:1px solid white; padding-bottom: 5px;">
							${application.student.firstName}
							${application.student.lastName}
							${application.dateRepresentation}
							<button class="button" Style="width: 7em; font-weight: 100; font-size: 15px;" onclick="location.href='./accept/${application.id}'">Accept</button>
							<button class="button" Style="width: 7em; font-weight: 100; font-size: 15px;" onclick="location.href='./decline/${application.id}'">Decline</button>
						</li>
					  	</c:forEach>
						</ul>
              		
          		
		</div>
	</li>
	
	<li class="coursesList" Style="width:31em;">
		<h1 Style="color:white; margin-left: 1em">Search for your courses:</h1>
		<form action="/Skeleton/findCompetenceLike"  commandName="searchQuery" method="get" Style="width: 50em; display:inline-flex; margin-left:1em">
    		<input type="text" name="searchQuery" path="searchQuery"/>
    		<input type="submit" value="Search" Style="height: 1.7em"></input>
		</form>
		<table Style="width: 21em;">
    		<c:forEach items="${competences}" var="competence">
        		<tr>
        			<td class="searchForCourses" onclick="location.href='tutorProfile/${competence.owner.id}'">
                		<div Style="text-align: right; margin-right:1em">${competence.description}, ${competence.grade}</div>
            		</td>
        		</tr>
    		</c:forEach>
  		</table>
  </li>
  <li Style="margin-left: 2em; text-align: justify">
  	<h1>
  		Search, Meet, Learn, Profit!	
  	</h1>
  		This is the heart of this website. Here you can search for courses and we will provide you with a list of tutors
  		who can help you with your studies. If you successfully arrange an appointment with a tutor or you get booked by another
  		student (you need to activate your tutor-status in your <a href="/Skeleton/tutorProfile">profile</a>) you will see your upcoming 
  		meetings on the left.
  </li>
</ul>  
  

<c:import url="template/footer.jsp" />
