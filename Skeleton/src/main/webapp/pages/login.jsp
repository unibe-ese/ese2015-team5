<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>





<c:import url="template/header.jsp" />

<!--

<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">       
    <c:if test="${param.error != null}">        
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">       
        <p>
            You have been logged out.
        </p>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>	
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>	
    </p>
    <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>

-->

<title>Insert title here</title>
</head>
<body>
 
<h1>
 
Login</h1><div id="login-error">

${error}</div><form action="./j_spring_security_check" method="post" >
 
 
 
<p>
 
 
 <label for="j_username">Username</label>
 <input id="j_username" name="j_username" type="text" />
</p><p>
 
 
 <label for="j_password">Password</label>
 <input id="j_password" name="j_password" type="password" />
</p><input  type="submit" value="Login"/> 

<c:import url="template/footer.jsp" />
