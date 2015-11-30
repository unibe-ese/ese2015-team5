<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

  <link rel="stylesheet" href="/Skeleton/css/skel.css" />
  <link rel="stylesheet" href="/Skeleton/css/style.css" />
  <link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />
  
<div Style="border: 2px solid white; border-radius: 10px; background: #B0CDEA"> 
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


<c:forEach items="${visitee.competences}" var="competence">
	<li Style="margin-top: 1em; margin-left: 2em; background: linear-gradient(to left, #5A86B0, #DBEAF9); border-radius: 10px; width: 20%">${competence.description}</li>
</c:forEach>

<div Style="margin-top: 3em;">
</div>


<div Style="border: 2px solid white; border-radius: 10px; background: #B0CDEA">
<button class="btn btn-primary"
                       onclick="location.href='/Skeleton/profile/${visitee.id}/lastWeek/${week.weekDays[0].dateString}/'"
                       Style="height:2em;">Last Week</button>
<button class="btn btn-primary"
                       onclick="location.href='/Skeleton/profile/${visitee.id}/nextWeek/${week.weekDays[0].dateString}/'"
                       Style="height:2em">Next Week</button>
<table>
  <tr>
    <c:forEach items="${week.weekDays}" var="day">
      <td>
        ${day.name}
        ${day.dateString}
        <ul>
          <c:forEach items="${day.courses}" var="course">
            <li>
              <div Style="text-align: center">${course.description}</div>
              <c:if test="${course.available == true}">
                <form action="./application" method="post">
                  <input name="courseId" value="${course.id}" type="hidden"/>
                  <input type="submit" value="${course.id}"/>
                </form>
              </c:if>
              <c:if test="${course.available == false}">

              </c:if>
            </li>
          </c:forEach>
        </ul>
      </td>
    </c:forEach>
  </tr>
</table>
</div>


<c:import url="template/footer.jsp" />
