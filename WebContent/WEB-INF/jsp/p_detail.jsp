<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>Bootstrap 101 Template</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/mystyle.css" rel="stylesheet">
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body style="background-color:#232830;">

<div class="container" style="background-color:white;">
<!-- head页面 -->
<jsp:include page="head.jsp"></jsp:include>
<!-- body页面 -->
	<div class="jumbotron">
		<!--<h1>Hello, world!</h1>-->
		<div class="row">
			<div class="col-md-6">
				<img src="image/6.jpg" width="500" height="300" class="img-rounded">
			</div>
			<div class="col-md-6">
				<p>This is a simple hero unit, a simple jumbotron-style component for calling
					extra attention to featured content or information.</p>
				<p>库存：1000</p>
				<p>单价：50</p>
				<p>评论：
					<ul>
						<li>可以</li>
						<li>不错</li>
					</ul>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p style="margin-top: 10px;">数量：<input style="width: 100px;height: 30px;" type="number" min="1" /></p>
				<p><a class="btn btn-primary btn-lg" href="#" role="button">立即购买</a></p>
			</div>
		</div>
	</div>
</div>
<!-- foot页面 -->
<jsp:include page="foot.jsp"></jsp:include>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.1.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>