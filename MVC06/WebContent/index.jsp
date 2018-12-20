<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file up download</title>
</head>
<body>
	<h1>upload</h1>
	<form action ="upload.do" method="post" enctype="multipart/form-data">
	<label for="file1">file</label><input type="file" name="file1"id="file1">
	<button type = "submit">upload</button>
	</form>
</body>
</html>