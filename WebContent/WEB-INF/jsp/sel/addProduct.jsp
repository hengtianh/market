<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<style type="text/css">
#tablebg {
	background: url('${pageContext.request.contextPath}/image/bg3.jpg')
		no-repeat;
	height: 640px;
}
</style>
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
        <div id="tablebg">
        <div class="row">
          <div class="col-md-12">
              <ol class="breadcrumb">
                  <li><a href="#">首页</a></li>
                  <li class="active">上架商品</li>
              </ol>
          </div>
        </div>
		<div class="row">
			<div class="col-md-3" style="padding-top: 50px;">
				<div class="main-left">
					<div class="main-nav"></div>
				</div>
			</div>

			<div class="col-md-6" style="padding-top: 50px;">

				<div class="panel panel-default">
					<div class="panel-heading">上架商品</div>
					<div class="panel-body">
						<table class="table-hover" width="200px" border="1"
							cellpadding="0" cellspacing="0">
							<tr align="center">
								<form
									action="${pageContext.request.contextPath}/category/product/addProduct.action"
									method="post" enctype="multipart/form-data">
									<input type="hidden" name="userid"
										value="${sessionScope.user.id}">
									<div class="form-group">
										<label for="cateitem">所属类别</label> <select
											class="form-control" name="cateitem">
											<c:forEach var="item" items="${requestScope.items}">
												<option value="${item.id}">${item.itemName}</option>
											</c:forEach>
										</select>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="pro_name">物品名称</label> <input name="pro_name"
													value="" type="text" class="form-control" id="pro_name"
													placeholder="pro_name">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="pro_desc">物品描述</label> <input name="pro_desc"
													value="" type="text" class="form-control" id="pro_desc"
													placeholder="pro_desc">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label for="price">单价</label> <input name="price" value=""
													type="text" class="form-control" id="price"
													placeholder="price">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label for="num">库存数量</label> <input name="num" value=""
													type="number" min="1" class="form-control" id="num"
													placeholder="num">
											</div>
										</div>
									</div>

									<div class="form-group">
										<label for="file">物品图片</label><p class="help-block">在这里添加商品的图片</p> <input type="file" id="file"
											name="proImg">
										
									</div>

									<button type="submit" class="btn btn-primary">添加</button>
									<div class="form-group">
										<label for="phone"></label>
										<!-- <input type="text" class="form-control" id="address" placeholder="address"> -->
									</div>
								</form>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		</div>
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>

	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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