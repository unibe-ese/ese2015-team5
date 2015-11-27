<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="template/header.jsp" />

<title>Login</title>
</head>
<body>

	<ul Style="display: inline-flex">
		<li Style="width: 40em">
			<h1>Login</h1>
			<div id="login-error">
				${error}
			</div>
				<form action="./j_spring_security_check" method="post" >
				<p>
					<label for="j_username">Username</label>
	 			   		<input id="j_username" name="j_username" type="text" />
					</p>
					<p>
						<label for="j_password">Password</label>
	 				   	<input id="j_password" name="j_password" type="password" />
					</p>
				<input  type="submit" value="Login" />
				or
	
			</form>
			<form action="/Skeleton/register" method="get">
				<input type="submit" value="Create Account"/>
			</form>
		</li>
		<li>
			<h1>Welcome to Stutor - Your possibility to make some easy ca$h!</h1>
			Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.
			
		</li>
	</ul>


<c:import url="template/footer.jsp" />
