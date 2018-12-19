<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="./css/frame.css"/>
</head>
<body>
<%@include file="../template/header.jspf" %>
<%@include file="../template/menu.jspf" %>
<h1>login page</h1>
<form action="" method="post">
	<div>
		<label for="empno">empno</label><input type = "text" name="empno" id="empno">
	</div>
		<div>
		<label for="name">name</label><input type = "text" name="name" id="name">
	</div>
	<div>
	<button type = "submit">login</button>
	<button type = "reset">cancel</button>
	</div>
</form>
<%@include file="../template/footer.jspf" %>
</body>
</html>