<%@page import="com.bit.day16.model.Emp02Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="css/frame.css"/>
</head>
<body>
<%@include file="../template/header.jspf" %>
<%@include file="../template/menu.jspf" %>	
	<h1>list</h1>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>연봉</th>
			<th>조회수</th>
		</tr>
		<%ArrayList<Emp02Dto> list=(ArrayList<Emp02Dto>)request.getAttribute("list");
		for(Emp02Dto bean:list){ //개선된 루프문 list에서 가져와서 bean으로 받음 
		%> 
		<tr>
			<td><%=bean.getEmpno() %></td>
			<td><%=bean.getName() %></td>
			<td><%=bean.getDdate()%></td>
			<td><%=bean.getPay()%></td>
			<td><%=bean.getCnt()%></td>
		</tr>
		<% }%>
	</table>
	<%@include file="../template/footer.jspf" %>
</body>
</html>