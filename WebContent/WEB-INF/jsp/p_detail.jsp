<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mystyle.css"
	rel="stylesheet">
<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<style type="text/css">
.p_font {
	font-family: 宋体;
	font-size: 12;
}
</style>
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="head.jsp"></jsp:include>
		<!-- body页面 -->

		<div class="jumbotron" style="background-color: #FDEECE;">
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
						<li><a href="#">首页</a></li>
						<li class="active">详细信息</li>
					</ol>
				</div>
			</div>
			<!--<h1>Hello, world!</h1>-->
			<div class="row">
				<div class="col-md-7">
					<img src="/pic/${pd.img}" width="600" height="400"
						class="img-rounded">
				</div>

				<div class="col-md-5">
					<div class="row">
						<div class="col-md-5 col-md-offset-1">
							<p class="lead"
								style="color: #F25C27; font-size: 24px; font-weight: bold;">${pd.pro_name}</p>
						</div>
						<div class="col-md-6"></div>
					</div>
					<div class="row">
						<div class="col-md-5 col-md-offset-2">
							<p class="p_font">单价：￥ ${pd.price}</p>
						</div>
						<div class="col-md-5"></div>
					</div>

					<div class="row" style="height:253px;">
						<div class="col-md-8 col-md-offset-2">
							<ul class="nav nav-tabs" role="tablist">
								<li class="active"><a href="#home" role="tab"
									data-toggle="tab">描述</a></li>
								<li><a href="#profile" role="tab" data-toggle="tab">库存</a></li>
								<li><a href="#messages" role="tab" data-toggle="tab">其他</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane active" id="home">
									<h3 style="color: #96979D;">物品描述</h3>
									<p style="color: #96979D; font-size: 14px;">${pd.pro_name}</p>
								</div>
								<div class="tab-pane" id="profile">
									<h3 style="color: #96979D;">库存 ${pd.num}件</h3>
									<p style="color: #96979D; font-size: 14px;">存货已不多，预购从速哦</p>
								</div>
								<div class="tab-pane" id="messages">
									<h3 style="color: #96979D;">其它</h3>
									<p style="color: #96979D; font-size: 14px;">Lorem Ipsum is
										simply dummy text of the printing and typesetting industry.
										Lorem Ipsum has been the industry's standard dummy text ever
										since the 1500s, when an unknown printer took a galley of type
										and scrambled it to make a type specimen book.</p>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
					<!-- Nav tabs -->
                    <div class="row">
                        <div class="col-md-5 col-md-offset-2">
                            <br> <a
                        href="${pageContext.request.contextPath}/order/addCart.action?id=${pd.pro_id}&info=${pd.pro_name}&price=${pd.price}"
                        class="btn btn-primary" role="button">加入购物车</a>
                        </div>
                    </div>
				</div>
			</div>
			<!-- <div class="row">
			<div class="col-md-12">
				<p style="margin-top: 10px;">数量：<input style="width: 100px;height: 30px;" type="number" min="1" value="1" /></p>
				<p><a class="btn btn-primary btn-lg" href="#" role="button">立即购买</a></p>
			</div>
		</div> -->
		</div>
		<!-- foot页面 -->
		<div class="container-fluid"
			style="height: 90px; background-color: gray;">
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