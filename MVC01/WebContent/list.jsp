<%@page import="com.bit.day15.model.Emp01Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
	text-align: center;
	}
	table{
	text-align:center;
	margin: 0px auto;
	width:80%;
	border-collapse: collapse;
	}
	tabe th, table td{
	border: 1px solid gary;
	}
	table tr:HOVER{
	background-color:purple;
	}
	
	td>a{
	display: block;
	color:black;
	table-decoration:none;
	}
	
	
</style>
<script type = "application/javascript">
if(<%=request.getParameter("result")%>)alert(<%=request.getParameter("result")%>);
</script>
</head>
<%
	ArrayList<Emp01Dto> list = (ArrayList<Emp01Dto>)request.getAttribute("alist");
%>
<body>
	<h1>리스트 페이지</h1>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>월급</th>
		</tr>

		<%
			for (int i = 0; i < list.size(); i++) {
				Emp01Dto bean = list.get(i);
		%>
		<tr>
			<td><a href="detail.bit?idx=<%=bean.getSabun()%>"><%=bean.getSabun()%></a></td>
			<td><a href="detail.bit?idx=<%=bean.getSabun()%>"><%=bean.getName()%></a></td>
			<td><a href="detail.bit?idx=<%=bean.getSabun()%>"><%=bean.getDdate()%></a></td>
			<td><a href="detail.bit?idx=<%=bean.getSabun()%>"><%=bean.getsal()%></a></td>
		</tr>
		<%
			}
		%>


	</table>
	<a href="add.bit">[입력]</a>
</body>
</html>