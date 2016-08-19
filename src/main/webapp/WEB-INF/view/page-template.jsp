<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="webtester" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/static/css/bootstrap.css">
<link rel="stylesheet" href="/static/css/bootstrap-theme.css">
<link rel="stylesheet" href="/static/css/app.css">

<link rel="shortcut icon" href="/static/images/favicon.png"
	type="/image/png">

<title>Web Tester</title>
</head>
<body class="webtester">
	<header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="text">
					<img src="/static/images/favicon_small.png">
					<h2>Web Tester system</h2>
				</div>
				<div class="text">
					<a href="/logout" class="btn btn-primary">Logout</a>
				</div>
			</div>
		</nav>
	</header>

	<div class="container test">

		<jsp:include page="${currentPage}"></jsp:include>

	</div>
	<webtester:footer />
	<!--  
	-->
	<script type="text/javascript" src="/static/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="/static/js/app.js"></script>

</body>
</html>