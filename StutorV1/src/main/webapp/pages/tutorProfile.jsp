<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div class="tabbable">
    <ul class="tabs">
        <li><a id="tab1btn" href="#tab1">General Information</a></li>
        <li><a id="tab2btn" href="#tab2">Tutoring Information</a></li>
    </ul>
    <div class="tabcontent">
		<div id="tab1" class="tab">
            <c:import url="generalProfileInformation.jsp" />
        </div>
        <div id="tab2" class="tab">
            <c:import url="tutorProfileInformation.jsp" />
        </div>
       
    </div>
</div>

<c:import url="template/footer.jsp" />
