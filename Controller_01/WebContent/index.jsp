<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SimpleController_01</title>
</head>
<body>
<!-- 
<form action="Test/Login" method="post">

在action中有两种表示方式：

1、"/Test/Login"  说明是相对于web服务器的根目录，可以理解为  http://localhost:8080/Test/Login

2、“Test/Login”  说明是相对于当前web应用程序的根目录,可以理解为  http://localhost:8080/项目名称/Test/Login 
-->
	<form action="login.haha" method="post">   <!-- action 表示要提交的地址 http://localhost:8080/Controller_01/login -->
		用户名:<input type="text" name="username" /><br> <br>
		密   码:<input type="text" name="password" /><br> <br>
		<input type="submit" value="login" />
	</form>
</body>
</html>