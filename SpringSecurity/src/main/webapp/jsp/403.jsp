<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<spring:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Hello from Spring Security App</title>
</head>
<body class="security-app">

	<div class="lc-block">
	<div class="alert-danger">
		<h3>
		   You do not have permission to access this page
		</h3>
     <form-action="/logout" method="post">
     <input type="submit" class="button red big" value="Sign in with different user"/>
     <input type="hidden" name="${_csrf.parameterName}" value="$_csrf.token"/>
     </form>
	</div>
</body>
</html>