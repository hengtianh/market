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
<script type="text/javascript">
	function uploadevent(status, picUrl) {
		status += '';
		switch (status) {
		case '1':
			var filename162 = picUrl + '_162.jpg';
			var filename48 = picUrl + '_48.jpg';
			var filename20 = picUrl + "_20.jpg";

			document.getElementById('avatar_priview').innerHTML = "头像1 : <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename162+"'/> <br/> 头像2: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename48+ "'/><br/> 头像3: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename20+ "'/>";

			break;
		case '-1':
			window.location.reload();
			break;
		default:
			window.location.reload();
		}
	}
</script>
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
		<div class="row" style="height: 640px;">
			<div class="col-md-3" style="margin-top: 50px;">
				<!-- Nav tabs -->
				<div>
					<ul class="nav nav-tabs nav-stacked" role="tablist">
						<li role="presentation" class="active"><a href="#home"
							aria-controls="home" role="tab" data-toggle="tab">上架商品</a></li>
						<!-- <li role="presentation"><a href="#profile"
							aria-controls="profile" role="tab" data-toggle="tab">添加图片</a></li> -->
					</ul>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="messages"
				style="margin-top: 50px;">
				<div class="tab-content col-md-8">
					<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
					<table class="table-hover" width="200px" border="1" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<form
								action="${pageContext.request.contextPath}/category/product/addProduct.action"
								method="post" enctype="multipart/form-data">
								<input type="hidden" name="userid"
									value="${sessionScope.user.id}">
								<div class="form-group">
									<label for="cateitem">cateitem</label> <select
										class="form-control" name="cateitem">
										<c:forEach var="item" items="${requestScope.items}">
											<option value="${item.id}">${item.itemName}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group">
									<label for="pro_name">pro_name</label> <input name="pro_name"
										value="" type="text" class="form-control" id="pro_name"
										placeholder="pro_name">
								</div>

								<div class="form-group">
									<label for="pro_desc">pro_desc</label> <input name="pro_desc"
										value="" type="text" class="form-control" id="pro_desc"
										placeholder="pro_desc">
								</div>

								<div class="form-group">
									<label for="price">price</label> <input name="price" value=""
										type="text" class="form-control" id="price"
										placeholder="price">
								</div>

								<div class="form-group">
									<label for="file">product image</label> <input type="file"
										id="file" name="proImg">
									<p class="help-block">在这里添加商品的图片</p>
								</div>

								<div class="form-group">
									<label for="num">num</label> <input name="num" value=""
										type="number" min="1" class="form-control" id="num"
										placeholder="num">
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
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>

	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>