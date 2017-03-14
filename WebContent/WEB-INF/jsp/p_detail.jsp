<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bootstrap 101 Template</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/mystyle.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
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
				<img src="/path/upload/${pd.img}" width="500" height="300" class="img-rounded">
			</div>
			<div class="col-md-6">
				<p>${pd.pro_desc}</p>
				<p>库存：${pd.num}</p>
				<p>单价：${pd.price}</p>
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
				<p style="margin-top: 10px;">数量：<input style="width: 100px;height: 30px;" type="number" min="1" value="1" /></p>
				<p><a class="btn btn-primary btn-lg" href="#" role="button">立即购买</a></p>
			</div>
		</div>
	</div>
<!-- foot页面 -->
<div class="container-fluid" style="height:90px;background-color:gray;">
	<p class="foot_p">&copy tianh.maker.com版权所有</p>
	<ul class="nav nav-pills  foot_a">
		<li role="presentation" class=""><a href="#">网站信息</a></li>
		<li role="presentation" class=""><a href="#">招聘信息</a></li>
		<li role="presentation" class=""><a href="#">帮助信息</a></li>
		<li role="presentation" class=""><a href="#">客户反馈</a></li>
		<li role="presentation" class=""><a href="#">联系我们</a></li>
	</ul>
	</div>
</div>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>