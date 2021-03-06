<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page generant une citation aleatoire</title>
<script type="text/javascript"
	src="/resources/js/jquery-2.2.0.js"></script>
<script type="text/javascript"
	src="/resources/js/bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap.css">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Display-quote v3</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#" id="quote-link" class="action-link">Citations <span
							class="sr-only">(selectionne)</span></a></li>
					<li><a href="#" alt="/stats" class="action-link">Statistiques</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login?logout">logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<div id="content-displayed">
			<%@include file="quote.jsp"%>
		</div>
		<input type="hidden" id="last-displayed-quote" value="1" />
		<input type="hidden" id="save-unquoted-url" value="/quotes/"/>
	</div>
	<script type="text/javascript"
		src="/resources/js/main-menu.js"></script>
</body>
</html>