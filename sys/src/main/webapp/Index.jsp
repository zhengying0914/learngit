<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>某宝</title>
</head>
<body>
<%
if(session.getAttribute("username")==null){
	response.sendRedirect("/sys/login");
}
%>

<table width="100%" height="100%" border="1" cellspacing="0">
  <tr height="100">
    <th colspan="2"><h1> 欢迎来到购物系统管理后台</h1></th>
      </tr >
  <tr height="100">
    <td width="15%">
      <a href="/sys/shop/type" target="main">商品类别管理</a>
    </td>
    <td rowspan="6"><iframe name="main" src="successLogin.jsp" frameborder="0" width="100%" height="100%"> </iframe></td>
  </tr>
  <tr height="100">
    <td><a href="/sys/shop/addDo" target="main">商品类别添加</a></td>
  </tr>
  <tr height="100">
    <td><a href="/sys/goods/showGoods" target="main">商品信息管理</a></td>
  </tr>
  <tr height="80">
    <td><a href="/sys/goods/toAddGoods" target="main">商品信息添加</a></td>
  </tr>
  <tr height="80">
    <td><a href="/sys/toLogin" >系统退出</a></td>
  </tr>
  </table>
</body>

</html>