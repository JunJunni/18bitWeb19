<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello..It's me..</title>
<link rel="stylesheet" style="text/css" href="css/frame.css" />
<style type="text/css">

.bx-wrapper {
	position: relative;
	margin: 0px auto;
}

.bx-prev,.bx-next {
	position: absolute;
	top: 0px;
	height: 300px;
	width: 80px;
	background-color: rgba(0, 0, 0, 0.2);
}
.bx-next {
	left: 520px;
}
</style>
<script type="application/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery.bxslider.js"></script>
<script type="text/javascript">
	$(function() {
		$('#bx').bxSlider({
			pager : false,
			auto : true,
			slideWidth:200,
			minSlides: 1,
			maxSlides: 3,
			moveSlides: 1

		});
	});
</script>

</head>
<body>
<div>
	<%@include file="template/header.jspf" %>
	<%@include file="template/menu.jspf" %>	
		<div id="content">
			<h1>Welcome</h1>
			<div id="bx">
			<div><img alt="img" src="imgs/small1.jpg" title="img1"></div>
			<div><img alt="img" src="imgs/small2.jpg" title="img2"></div>
			<div><img alt="img" src="imgs/small3.jpg" title="img3"></div>
			<div><img alt="img" src="imgs/small4.jpg" title="img4"></div>
			<div><img alt="img" src="imgs/small5.jpg" title="img5"></div>
			<div><img alt="img" src="imgs/small6.jpg" title="img6"></div>
			</div>
		</div>
	<%@include file="template/footer.jspf" %>	
	</div>
</body>
</html>