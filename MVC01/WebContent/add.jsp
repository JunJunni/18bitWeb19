<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type = "application/javascript">
window.onload=function(){
	var btn=document.querySelector('button[type="button"]');
	btn.onclick=function(){
		window.history.back();
	};
};
</script>
</head>
<body>
<h1>입력</h1>
 <!-- 입력을 처리할 page 는 insert.bit이다. -->
<form action="insert.bit" method="post">

		<div>
		<label for = "name">이름</label>
		<input type = "text" name ="name" id ="name"/>
	</div>
		<div>
		<label for = "sal">연봉</label>
		<input type = "text" name ="sal" id ="sal"/>
	</div>
	<div>
		<button type = "submit">입력</button>
		<button type = "reset">취소</button>
		<button type = "button">뒤로</button>
	</div>
</form>
</body>
</html>