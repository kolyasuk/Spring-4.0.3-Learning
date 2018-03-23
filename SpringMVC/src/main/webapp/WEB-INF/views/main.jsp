<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<p>Name: ${user.name}</p>
	<p>Password: ${user.password}</p>
	<p>isAdmin: ${user.admin}</p>

	<p> ${redirect}</p>

	Controller worked ${endTime} ms.

</body>
</html>