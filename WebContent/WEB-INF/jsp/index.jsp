<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>index</title>

	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/mystyle.css" rel="stylesheet">
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
<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
<!-- body页面 -->
	<div class="row">
		<div class="col-md-2">
			<div class="main-left">
				<div class="main-nav">
					<p id="btn1" onmouseover="navshow($('#nav1'))">电子产品</p>
					<div id="nav1" class="nav1">
						<ul>
							<li><a href="#">二手电脑</a></li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
						</ul>
					</div>
					<p id="btn2" onmouseover="navshow($('#nav2'))">床上用品</p>
					<div id="nav2" class="nav1">
						<ul>
							<li><a href="#">二手电脑</a></li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
						</ul>
					</div>
					<p id="btn3" onmouseover="navshow($('#nav3'))">居家出行</p>
					<div id="nav3" class="nav1">
						<ul>
							<li><a href="#">二手电脑</a></li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
							<li><a href="#">二手电脑</a> </li>
							<div class="hr"></div>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-9 col-md-offset-1">
			<div class="row">
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="p_detail.jsp"><img src="image/6.jpg" alt="..."></a>
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="image/6.jpg" alt="...">
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="image/6.jpg" alt="...">
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="image/6.jpg" alt="...">
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>



<!-- foot页面 -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>




<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/validate.js"></script>
	<script>
		function navshow(obj) {
			obj.toggle('blind');
			//obj.css('display','block');
		}
		function navhidde(obj) {
			//obj.hide('blind');
			obj.css('display','none')
		}	
	</script>
</body>
</html>