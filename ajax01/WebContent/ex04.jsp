<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var btn,div,xhr;
	 window.onload=function(){
		 btn=document.querySelector('button');
		 div=document.querySelector('div');
		 
		 btn.addEventListener("click", function(){
			 xhr=new XMLHttpRequest();
			 xhr.onreadystatechange=function(){
				 
				 if(xhr.readyState==4 && xhr.status==200){
				 var temp = xhr.responseText;
				 var obj = JSON.parse(temp);
				 div.innerHTML='<h2>'+obj.root[0].id+'</h2>'+'<p>'+obj.root[0].name+'</p>';
				 }
			 };
			 xhr.open('GET','result04.json',true);
			 xhr.send();
		 });
	 };
</script>
</head>
<body>
	<h1>json을 이용한 ajax 통신</h1>
	<div>
		<button>json파싱</button>
	</div>
</body>
</html>