<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

  <ul class="newsfeedList">
    <h1>Rendez Vous</h1>
    <div class="newsfeed">
      <li>
        <c:forEach items="${newsfeed}" var="news">
          <ul class="newsEntryElement">
            <div class="${news.tutorCourse ? 'newsEntryContainer tutorNews' : 'newsEntryContainer studentNews'}">
              <c:if test="${news.tutorCourse == true}">
                Course
              </c:if>
              <c:if test="${news.tutorCourse == false}">
                Lesson
              </c:if>
              <li class="newsEntryListing">
                <ul class="newsEntryListing-date">
                ${news.dateRepresentation}
              </ul>
              <ul class="newsEntryListing-name">
                ${news.partner.firstName}
                ${news.partner.lastName}
              </ul>
            </div>
          </ul>
        </c:forEach>
      </li>
    </div>
  </ul>
  <ul class="coursesList">
<h1>Search for your courses:</h1>
<form action="/Skeleton/findCompetenceLike"  commandName="searchQuery" method="get" Style="width: 50em; display:inline-flex">
    <input type="text" name="searchQuery" path="searchQuery"/>
    <input type="submit" value="Search" Style="height: 1.7em"></input>
</form>
<table Style="width: 20em;">
    <c:forEach items="${competences}" var="competence">
        <tr>
            <td class="courses" onclick="location.href='profile/${competence.owner.id}'">
                ${competence.description}, ${competence.grade}
            </td>
        </tr>
    </c:forEach>
  </table>
  </ul>


  <ul class="applicationsList" style="float:right">
  <h1>Applications:</h1>
  <c:forEach items="${applications}" var="application">
      <tr>
          <td>
              ${application.tutor.firstName}
              ${application.student.firstName}
              <button onclick="location.href='./accept/${application.id}'">Accept</button>
              <button onclick="location.href='./decline/${application.id}'">Decline</button>
          </td>
      </tr>
  </c:forEach>
  </ul>



<c:import url="template/footer.jsp" />
