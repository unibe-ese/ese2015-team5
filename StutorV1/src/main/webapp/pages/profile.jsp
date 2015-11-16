<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="template/header.jsp" />


<!doctype html>
<html lang="en">

<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Personal Information</a></li>
    <li><a href="#tabs-2">Tutor Information</a></li>
  </ul>
  <div id="tabs-1">
  	<c:import url="nonTutorProfile.jsp" />
  </div>
  <div id="tabs-2">
  	<c:import url="tutorProfile.jsp" />
  </div>
</div>
 
 
</body>
</html>


<c:import url="template/footer.jsp" />
