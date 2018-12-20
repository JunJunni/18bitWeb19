<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>download page</title>
</head>
<body>
<h1>download page</h1>

<a href="download.do?file=<%=request.getAttribute("file") %>&fname=<%=request.getAttribute("fname") %>">down</a>
<!-- 위의 코드 param으로 진짜 파일이름과 가짜파일이름을 모두 던지고, down.do라는 컨트롤러로 할것임 -->
</body>
</html>