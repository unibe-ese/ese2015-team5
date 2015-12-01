<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<script src="/Skeleton/js/registrationSuccess.js"></script>


<title>Login</title>
</head>
<body>

	<ul Style="display: inline-flex">
		<li Style="width: 40em; margin-right: 10em">
			<label id="registration-Message"></label>
			<div class="help-inline">
				${error}
			</div>
			<h1>Login</h1>

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
			</form>
			<form action="/Skeleton/register" method="get">
				<input type="submit" value="Create Account"/>
			</form>

		</li>
		<li Style="text-align: justify">
			<h1>Welcome to Stutor - Your possibility to make some easy ca$h!</h1>
			Sounds too good to be true right?! But this is the 21st century,
			everything is possible. There are self driving cars, core fusion research
			and even beer mixed with coca-cola. So why shouldn't there be students with
			actual money?
			The concept is simple: you pass an exam and you are henceforth a perfectly
			qualified tutor for this specific course. After that we will help you to find a
			student or rather help the student find you. All you have to do to profit
			from this awesome and unique easy-money-service is to <a href=/Skeleton/register>register right now</a> and
			become part of this worthy experience.
			<p>By registering you accept your soul transfer to Stutor™.

		</li>
	</ul>


<c:import url="template/footer.jsp" />
