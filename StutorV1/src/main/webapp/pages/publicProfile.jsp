<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

  <link rel="stylesheet" href="/Skeleton/css/skel.css" />
  <link rel="stylesheet" href="/Skeleton/css/style.css" />
  <link rel="stylesheet" href="/Skeleton/css/style-desktop.css" />


${visitee.email}

<div>${visitee.aboutYou}</div>
<img src="/Skeleton/imageDisplay$userId=${visitee.id}" style="height:100px; width:100px"/>
<c:forEach items="${visitee.competences}" var="competence">
    <li>
        ${competence.description}
    </li>
</c:forEach>

<table>
  <tr>
    <c:forEach items="${week.weekDays}" var="day">
      <td>
        ${day.name}
        ${day.dateString}
        <ul>
          <c:forEach items="${day.courses}" var="course">
            <li>
              ${course.slot}
              ${course.description}
            </li>
          </c:forEach>
        </ul>
      </td>
    </c:forEach>
  </tr>
</table>


<c:import url="template/footer.jsp" />
