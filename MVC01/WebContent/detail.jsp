<%@page import="com.bit.day15.model.Emp01Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div>div {
	display: inline-block;
}

div>div:first-childe {
	width: 150px;
	background-color: #e9e9e9);
}

div>div:last-childe {
	border: 3px solid gray;
	box-sizing: border-box;
	width: 450px;
}
</style>
<script type="text/javascript">
	window.onload = function() {
		var backbtn = document.querySelectorAll('a')[2];
		backbtn.onclick = function() {
			window.history.back();
			return false;
		}
	};
</script>
</head>
<%
	Emp01Dto bean = (Emp01Dto)request.getAttribute("bean");
%>
<body>
	<h1>상세페이지</h1>
	<div>
		<div>사번</div>
		<div><%=bean.getSabun()%></div>
	</div>
	<div>
		<div>이름</div>
		<div><%=bean.getName()%></div>
	</div>
	<div>
		<div>날짜</div>
		<div><%=bean.getDdate()%></div>
	</div>
	<div>
		<div>연봉</div>
		<div><%=bean.getsal()%></div>
	</div>
	<div>
	<a href="edit.bit?idx=<%=bean.getSabun()%>">수정</a>
	<a href="edl.bit?idx=<%=bean.getSabun()%>">삭제</a>
	<a href="#">뒤로</a>

	</div>
</body>
</html>