<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
<h2>系统商品类别如下</h2>
<!-- <h1> -->
<!-- <a href="/myshoysys/shop/pe" target="main">体育用品</a><br><br> -->
<!-- <a href="" target="main">零食</a><br><br> -->
<!-- <a href="" target="main">衣服</a><br><br> -->
<!-- </h1> -->
<table width="30%" border=1>  
<tbody>

<tr>  
    <td>编号</td>  
    <td>类型</td> 
    <td>操作</td>   
    
</tr>  
<c:forEach items="${types}" var="data">  
<tr>  
    <td>${data.id}</td>  
    <td>${data.name}</td>  
    <td><a href="/sys/shop/updateDo/${data.id}">修改</a> 
    <a href="/sys/shop/toDelete/${date.id}">删除</a></td>  
</tr>  
</c:forEach>  
</tbody>
</table>
</center>
</body>
</html>