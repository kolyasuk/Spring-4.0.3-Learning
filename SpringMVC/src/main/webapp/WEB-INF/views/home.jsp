<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
<meta charset="UTF-8">
<title>Calm breeze login screen</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>

<body>

	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>


			<form:form cssClass="form" method="POST" commandName="user" action="check-user">
				<form:input cssClass="stle" path="name"/> 
				<form:errors path="name"></form:errors>
				<form:input cssClass="stle" path="password"/>
				<form:errors path="password"></form:errors><br>
				<form:label path="">Admin<form:checkbox path="admin"/></form:label>
				<button type="submit" id="login-button" title="Click to login">Login</button>
			</form:form>
		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>

</html>
