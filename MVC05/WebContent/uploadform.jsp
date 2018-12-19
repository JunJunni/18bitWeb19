<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadform</title>
</head>
<body>
<form method = "post" enctype="multipart/form-data">
<div>
<label for="empno">empno</label><input type="text" name="empno" id="empno"/>
</div>
<div>
<label for="file">file</label><input type="file" name="file" id="file"/>
</div>
<div>
	<button type ="submit">upload</button>
</div>
</form>
</body>
</html>