<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
//parent.window.document.location.href='Index.jsp';
</script>
<%
request.setCharacterEncoding("utf-8");
String username=(String)session.getAttribute("username");
%>
<center>
<h2>
<br><br><br><br><br><br>
欢迎${username}登陆购物系统
</h2>
</center>
</body>
</html>