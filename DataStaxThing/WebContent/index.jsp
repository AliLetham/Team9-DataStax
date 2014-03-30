<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blink</title>
</head>
<body>

<div id= "titleBar">

<% request.getSession(false);
if(session!=null)
session.invalidate(); %>

<h1> BLINK </h1>


<div id = "loginDiv">
<a id = "loginLink" href="login.jsp">Login</a>
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

</div>

<div id="container">





<div id="rightColumn">
<br>
<h3>&nbsp;Register</h3>
<br>
&nbsp;&nbsp;&nbsp;Please enter your details: 

<form name="input" action="Register" method="POST">
<br>
&nbsp;&nbsp;&nbsp;Username:&nbsp; <input type="text" name="username"><br>
&nbsp;&nbsp;&nbsp;Password:&nbsp; <input type="password" name="password"> <br>
&nbsp;&nbsp;&nbsp;Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="email"> <br>
&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">
</form>
</div>


<div id="leftColumn">

<video width="640" height="390" controls>
  <source src="http://127.0.0.1:8080/DataStaxThing/files/f1ab03eb-4ed0-4564-a385-ba0f27b9a482.mp4" type="video/mp4">
</video>

</div>

<div id= "taglineDiv">
<b><i>HOW DID THEY DO IT? </i></b>
</div>

</div>

<div id= "legalDiv2">
HI

</div>





</body>
</html>