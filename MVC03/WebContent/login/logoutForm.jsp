<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/frame.css" />
</head>
<body>
	<div>
		<div id="header">
			<h1>비트교육센터</h1>
		</div>
		<div id="menu">
			<a href="#">HOME</a> <a href="#">INTRO</a> <a href="#">BBS</a> <a
				href="#">LOGIN</a>

		</div>
		<div id="content">
			<h1>로그인 페이지</h1>
			<form method="POST">
				<div>

					<label for="id">id</label><input type="text" name="id"
						id="id">
				</div>
				<div>

					<label for="pw">pw</label><input type="password" name="pw"
						id="pw">
				</div>				
				<div>

					<button type="submit">login</button>
					<button type="reset">reset</button>
				</div>
			</form>
		</div>
		<div id="footer">
			<address>비트캠프 서울시 서초구 서초동 1327-15 비트아카데미빌딩</address>
			Copyright &copy; 비트캠프 All rights reserved.
		</div>
	</div>
</body>
</html>
