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
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mystyle.css"
	rel="stylesheet">
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
		<blockquote>
			<p>
				<strong style="font-size:28px;color:#F25C27;">最新上架物品</strong>
			</p>
		</blockquote>
		<hr>
		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
			<c:set value="active" var="c"></c:set>
			<c:forEach items="${requestScope.products}" var="p">
				<li data-target="#myCarousel" data-slide-to="${p.id}" class="${c}"></li>
				<c:remove var="c"/>
				</c:forEach>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
			<c:set value="active" var="c"></c:set>
			<c:forEach items="${requestScope.products}" var="p">
			     <div class="item ${c}">
                    <img src="/pic/${p.img}"
                        alt="Second slide">
                    <div class="carousel-caption">${p.pro_name}</div>
                </div>
                <c:remove var="c"/>
			</c:forEach>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
        
        <br />
        <div class="row">
        <div class="col-md-12 col-md-offset-0">
        <blockquote>
            <p>
                <strong style="font-size:28px;color:#F25C27;">所有在售物品</strong>
            </p>
        </blockquote>
        <hr>
        </div>
        </div>
		<div class="row" style="height: 640px;">
			<div class="col-md-3">
				<div class="main-left">
					<div class="main-nav"></div>
				</div>
			</div>

			<div class="col-md-9" id="messages">
				<div class="row">
					<c:forEach items="${products}" var="p">
						<div class="col-md-4">
							<div class="thumbnail">
								<a
									href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}"><img
									src="/pic/${p.img}" alt="..." width="168" height="198"></a>
								<div class="caption">
									<h3>${p.pro_name}</h3>
									<p>${p.pro_desc}</p>
									<p>
										<a
											href="${pageContext.request.contextPath}/order/addCart.action?id=${p.pro_id}&info=${p.pro_name}&price=${p.price}"
											class="btn btn-primary" role="button">加入购物车</a> <a
											href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}"
											class="btn btn-default" role="button">查看信息</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				<!-- 分页的导航条 -->
				<div class="container row">
					<div class="col-md-offset-3 col-md-7">
						<nav>
							<ul class="pagination">
								<li><a
									href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${pageOrder.pageIndex<=1?1:pageOrder.pageIndex-1}&type=${pageOrder.type}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="page" items="${pageOrder.pages}">
									<li><a
										href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${page}&type=${pageOrder.type}">${page}</a></li>
								</c:forEach>
								<!-- 下一页 -->
								<li><a
									href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${pageOrder.pageIndex>=pageOrder.pageCount?pageOrder.pageCount:pageOrder.pageIndex+1}&type=${pageOrder.type}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
	</div>
	<script src="${pageContext.request.contextPath}/js/validate.js"></script>
	<script src="${pageContext.request.contextPath}/js/category.js"></script>
	<script>
		function showNav(value) {
			var index = value + 1;
			var div = document.getElementById('nav' + index);
			$(div).toggle('blind');
		}
	</script>
</body>
</html>
