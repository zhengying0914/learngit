<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
   <h3>用户登陆</h3>
   <form name="frmlog" method="post"  action="login.do?op=log">
   
   用户名：<input name="username" type="text"/><br/>
   密码：<input name="password" type="password"/><br/>
   <input type="submit" name="btnlog" value="登陆"/>
   </form>
</body>
</html>