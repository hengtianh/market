<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>index</title>

	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/mystyle.css" rel="stylesheet">
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
				<!-- 
					<p id="btn1" onmouseover="showNav($('#nav1'))">电子产品</p>
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
					</div>  -->
				</div>
			</div>
		</div>

		<div class="col-md-9 col-md-offset-1">
			<div class="row">
			
			<c:forEach items="${products}" var="p">
			   <div class="col-md-4">
					<div class="thumbnail">
						<a href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}"><img src="/path/upload/${p.img}" alt="..." width="168" height="198"></a>
						<div class="caption">
							<h3>${p.pro_name}</h3>
							<p>${p.pro_desc}</p>
							<p><a href="#" class="btn btn-primary" role="button">加入购物车</a> <a href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}" class="btn btn-default" role="button">查看信息</a></p>
						</div>
					</div>
				</div>
			</c:forEach>
				

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="${pageContext.request.contextPath}/image/6.jpg" alt="..." width="168" height="168">
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="${pageContext.request.contextPath}/image/6.jpg" alt="..." width="168" height="168">
						<div class="caption">
							<h3>Thumbnail label</h3>
							<p>...</p>
							<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="thumbnail">
						<img src="${pageContext.request.contextPath}/image/6.jpg" alt="..." width="168" height="168">
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
<script src="${pageContext.request.contextPath}/js/category.js"></script>
	<script>
		function showNav(value){
			var index = value+1;
			var div = document.getElementById('nav'+index);
			$(div).toggle('blind');
		}
		
	</script>
</body>
</html>