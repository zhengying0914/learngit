<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<form action="/sys/goods/doUpdate" method="post">  
<%--         <input type="hidden" name="id" value="${user.id }">   --%>
        编号：<input type="text" name="id" value="${goods.id}"><br/>  
        商品名称： <input type="text" name="goods_name" value="${goods['goods_name']}"><br/> 
         商品价格<input type="text" name="goods_price" value="${goods['goods_price']}"><br/>  
        商品类型： <input type="text" name="goods_type" value="${goods['goods_type']}"><br/> 
        库存数： <input type="text" name="goods_number" value="${goods['goods_number']}"><br/> 
        <input type="submit" value="修改">  
    </form> 
    </center> 
</body>
</html>