<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>
</head>


<body>

<% if (request.getSession().getAttribute("user") != null) {  
 response.sendRedirect(request.getContextPath()+"/userHub.jsp");
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

<div id="container">

<div id="registerColumn">
<br>
<h3>&nbsp;Register</h3>
&nbsp;&nbsp;&nbsp;Please enter your details: 

<form name="input" action="Register" method="POST">
<br>
&nbsp;&nbsp;&nbsp;Username:&nbsp; <input type="text" name="username"><br>
&nbsp;&nbsp;&nbsp;Password:&nbsp; <input type="password" name="password">
&nbsp;&nbsp;&nbsp;Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="email"> <br>
&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">
</form>
</div>



<div id="loginColumn">
<br>
<h3>&nbsp;Login</h3>
&nbsp;&nbsp;&nbsp;Please enter your details: 

<form name="input" action="Login" method="POST">
<br>
&nbsp;&nbsp;&nbsp;Username:&nbsp; <input type="text" name="username"><br>
&nbsp;&nbsp;&nbsp;Password:&nbsp; <input type="password" name="password"> <br>
&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">
</form>
<br>
&nbsp;&nbsp;&nbsp;Forgotten your password? 
</div>
</div>

<div id= "legalDiv2">
HI

</div>


</body>
</html>