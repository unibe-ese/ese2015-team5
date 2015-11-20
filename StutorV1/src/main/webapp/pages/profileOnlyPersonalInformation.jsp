<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="template/header.jsp" />

<div class="tabbable">
    <ul class="tabs">
        <li><a href="#tab1">Personal Information</a></li>
    </ul>
    <div class="tabcontent">
        <div id="tab1" class="tab">
            <c:import url="nonTutorProfile.jsp" />
        </div>
    </div>
</div>

<c:import url="template/footer.jsp" />
