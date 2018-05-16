<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String controller = "GoogleDriveFileNew";
%>
<!DOCTYPE html>
<html lang="en">
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

	<fieldset>
		<legend>
			MusicxMatch search for
			<c:out value="${param.searchQuery}" />
		</legend>
		<span>
			<div>
				<p>








					<c:forEach items="${requestScope.letras}" var="letra">
						<span><c:out value="${letra}" /></span>
						<br />
					</c:forEach>








				</p>
			</div>
		</span>
	</fieldset>



	<c:forEach items="${requestScope.videos}" var="video"></c:forEach>

	<c:forEach items="${requestScope.videos}" var="video" end="0">

		<center>
			<center>
				<p>
					<iframe class="button-api-frame"
						src="https://youtubemp3api.com/@api/button/mp3/<c:out value="${video.id.videoId}"/>"
						width="50%" height="50%" allowtransparency="true" scrolling="no"
						style="border: none"></iframe>
				</p>
			</center>
			<br />
	</c:forEach>






	<div>
		<form id="uploadGDForm" action="<%=controller%>" method="post"
			class="btn-large waves-effect waves-light teal lighten-1">
			<input type="hidden" name="title" required
				value="${param.searchQuery}" /> <input type="submit"
				name="importOnGoogleDrive" title="gdrive" style="color: white;"
				value="Import on Google Drive">
		</form>
	</div>

	<p>
	<th>Token:
	<th>
	<td><c:out value='${sessionScope["GoogleDrive-token"]}' />
	</p>
	</center>


</body>






</html>
