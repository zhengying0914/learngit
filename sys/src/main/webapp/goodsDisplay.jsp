<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<table width="40%" border=1>  
<tbody>

<tr>  
    <td>编号</td>  
    <td>商品名称</td> 
    <td>价格</td>  
    <td>商品类别</td> 
    <td>库存数量</td>
    <td>操作</td>
    
</tr>  
<c:forEach items="${goods}" var="data">  
<tr>  
    <td>${data.id}</td>  
    <td>${data["goods_name"]}</td> 
    <td>${data["goods_price"]}</td>  
    <td>${data["goods_type"]}</td>  
    <td>${data["goods_number"]}</td>   
    <td><a href="/sys/goods/toUpdate/${data.id}">修改</a> 
    <a href="/sys/goods/toDelete/${data.id}">删除</a></td>  
</tr>  
</c:forEach>  
</tbody>
</table>
</center>
</body>
</html>