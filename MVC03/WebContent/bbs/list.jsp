<%@page import="com.bit.day17.model.Emp03Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/frame.css" />
<style type="text/css">
.row{
		border: 1px solid gray;
		width: 80%;
		height: 80px;
		border-radius:10px;
		margin-bottom: 5px;
		line-height: 80px;
	}
	.row>span:nth-child(3){
		float: right;
		height: 80px;
		border-left: 1px solid gray;
		width: 50px;
		text-align: center;
	}
	.row>span:nth-child(1){
		float: left;
		height: 80px;
		border-right: 1px solid gray;
		border-radius:10px 0px 0px 10px;
		background-color:yellow;
		width: 50px;
		text-align: center;
</style>
</head>
<body>
	<div>
		<div id="header">
			<h1>비트교육센터</h1>
		</div>
		<div id="menu">
		<a href = "#">HOME</a>
		<a href = "#">INTRO</a>
		<a href = "#">BBS</a>
		<a href = "#">LOGIN</a>
		</div>
		<div id="content">
			<h1>리스트 페이지</h1>
			<%
			ArrayList<Emp03Dto> list =(ArrayList<Emp03Dto>)request.getAttribute("alist");
			for(Emp03Dto bean:list){
			%>
			<div class="row">
			<span><%=bean.getEmpno()%></span>
			<span><%=bean.getSub()%></span>
			<span><%=bean.getCnt()%></span>
			</div>
			<%} %>
		</div>
		<div id="footer">
		<address>비트캠프 서울시 서초구 서초동 1327-15 비트아카데미빌딩</address>
		Copyright &copy; 비트캠프 All rights reserved.
		</div>

	</div>
</body>
</html>