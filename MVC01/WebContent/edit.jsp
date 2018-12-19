<%@page import="com.bit.day15.model.Emp01Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		var backbtn=document.querySelectorAll("button")[2];
		backbtn.onclick=function(){
			window.history.back();
		};
	};
</script>
</head>
<body>
	<h1>수정페이지</h1>
	<form action="update.bit" method="post">
	<%Emp01Dto bean = (Emp01Dto)request.getAttribute("bean"); %>
			<div>
				<label for="sabun">사번</label><input type="text" name="sabun" id="sabun" value="<%=bean.getSabun()%>" readonly="readonly">
			</div>
			<div>
				<label for="name">이름</label><input type="text" name="name" id="name" value="<%=bean.getName()%>">
			</div>
			<div>
				<label for="ddate">날짜</label><input type="text" name="ddate" id="ddate" value="<%=bean.getDdate()%>" disabled="disabled">
			</div>
			<div>
				<label for="sal">월급</label> <input type="text" name="sal" id="sal" value="<%=bean.getsal()%>">
			</div>
		<div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
			<button type="button">뒤로</button>
		</div>

	</form>
</body>
</html>