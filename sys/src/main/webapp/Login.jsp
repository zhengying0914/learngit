<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<center>
<br><br>
<h1>请输入正确的账号密码登陆</h1>
<hr>
<br><br><br><br>
<!--  -->
<form action="/sys/login"  target="_self" method="post" >
用户:<input type="text" name="username"><br><br>
密码:<input type="password" name="password"><br><br>
<input type="submit" value="登陆" >
</form>
</center>
</body>
</html>