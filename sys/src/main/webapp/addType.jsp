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
<h2>请输入你要添加的编号和商品类别</h2>
<br><br><br>

 <form action="/sys/shop/addType" method="post" accept-charset="UTF-8"> 
         商品编号：<input type="text" name="id"><br/><br>
        商品类别：<input type="text" name="name"><br/><br>
           <input type="submit" value="添加商品类别">  
    </form>  
</center>
</body>
</html>