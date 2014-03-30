<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if (request.getSession().getAttribute("user") == null) {  
 response.sendRedirect(request.getContextPath()+"/login.jsp");
 }
%>

<div id= "titleBar">

<h1> BLINK </h1>

<div id = "loginDiv">
<a id = "loginLink" href="url">Login</a>
</div>

</div>

<div id="navigationBar">
<ul>
<li> <h2>NavBar</h2></li>
<li><a href="userHub.jsp"> Your Hub</a></li>
<li><br></li>
<li><a href="topVideos.jsp"> Top Videos</a></li>
<li><a href="topVideos.jsp"> Your Videos</a></li>
<li><a href="topVideos.jsp"> New Videos</a></li>
<li><a href="topVideos.jsp"> Favourite Videos</a></li>
<li> <br> </li>
<li><a href="gameList.jsp"> Games</a></li>
<li><a href="video.jsp"> CS:GO </a></li>
<li><a href="video.jsp"> Runescape </a></li>
<li><a href="video.jsp"> League of Legends </a></li>
<li><a href="video.jsp"> Dark Souls II  </a></li>
<li> <br> </li>
<li><a href="settings.jsp"> Settings  </a></li>
</ul>
</div>


<div id="usersVideosContainer">

<c:forEach var="userVideo" items="${usersVideos}">
  <div id="usersVideos">
  <c:out value="${userVideo.title}"></c:out>  
  <br>
   <video width="320" height="240" controls>
  <source src="${userVideo.videoLink}" type="video/mp4">
</video>
</div>
</c:forEach>

</div>

<div id= "legalDiv2">
HI

</div>
</body>
</html>