<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Log In </h1>

<form action="login" method="post">



Username  <input type="text" name="username"> <br>

Password <input type="password" name="password"> <br>

<input type="submit" value="Log In " >


</form>



<br>

<p> ${error } </p>

<a href="signup.jsp"> Sign Up Form</a>








</body>
</html>