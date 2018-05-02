<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-GB">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Search - Sing It Later</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
<body>

	<nav class="white" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="index.html" class="brand-logo"> <img
				src="images/logos/minilogochars.png" width="169" height="25"
				alt="Sing It Later">
			</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="#">AISS</a></li>
			</ul>

			<ul id="nav-mobile" class="sidenav">
				<li><a href="#">AISS</a></li>
			</ul>
			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
	</nav>

	<div class="container">
		<div class="section">

			<!--   Results   -->

			<div class="col s12 m4">
				<div class="icon-block">
					<!--   Comentado
                        <h2 class="center brown-text">
                        <img src="images/elementos/lupa.png" width="50" height="65">
                    </h2>
                    -->

					<p>
					<h4 class="center">
						<img src="images/elementos/lupa.png" width="16" height="21">
						Search <img src="images/elementos/lupa.png" width="16" height="21">
					</h4>

					</p>
					<center>
						<p class="light">Related results:</p>
					</center>
				</div>
			</div>

		</div>

		<center>
			<p>
			<fieldset id="youtube">
				<legend>
					YouTube search for
					<c:out value="${param.searchQuery}" />
				</legend>
				<c:forEach items="${requestScope.videos}" var="video">

					<iframe width="300" height="169"
						src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}"/> ">
					</iframe>
					<br>

				</c:forEach>
			</fieldset>
			</p>
		</center>
	</div>
</body>

</html>
