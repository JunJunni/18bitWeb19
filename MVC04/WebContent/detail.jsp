<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
</head>
<body>
	<%@include file="template/header.jspf"%>
	<%@include file="template/menu.jspf"%>
	<jsp:useBean id="bean" class="com.bit.day18.model.Emp03Dto"
		scope="request"></jsp:useBean>
	<h1>Detail page</h1>
	<div>
		<div>
			<span>No.</span> <span><jsp:getProperty property="num"
					name="bean" /></span> <span>writer</span> <span><jsp:getProperty
					property="unum" name="bean" /></span> <span>hits</span> <span><jsp:getProperty
					property="cnt" name="bean" /></span>
		</div>
		<div>
			<span>subject</span> <span><jsp:getProperty property="sub"
					name="bean" /></span>
		</div>
		<div><jsp:getProperty property="content" name="bean" /></div>
	</div>
	<%@include file="template/footer.jspf"%>
</body>
</html>