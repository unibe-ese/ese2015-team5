<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div id="tab1" class="nonTutorProfile">
    <c:import url="nonTutorProfile.jsp" />
</div>
<div id="tab2" class="tutorProfile">
    <c:import url="tutorProfile.jsp" />
</div>



<c:import url="template/footer.jsp" />
