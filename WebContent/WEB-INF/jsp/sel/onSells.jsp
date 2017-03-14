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
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
			<div class="row" style="height:640px;">
				<div class="col-md-3" style="margin-top:50px;">
					<!-- Nav tabs -->
					<div>
						<ul class="nav nav-tabs nav-stacked" role="tablist">
							<li role="presentation"><a href="#messages"
								aria-controls="messages" role="tab" data-toggle="tab">在售商品</a></li>
						</ul>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="messages" style="margin-top:50px;">
					<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
					<table class="table-hover" width="800px" border="1"
						cellpadding="0" cellspacing="0">
						<tr align="center">
							<td class="active">id</td>
							<td class="warning">名称</td>
							<td class="info">单价</td>
							<td class="info">库存</td>
							<td class="info">图片</td>
							<td class="danger">描述</td>
							<td class="danger">操作</td>
						</tr>
						<c:forEach items="${pl}" var="product">
							<tr align="center">
								<td class="active">${product.id}</td>
								<%-- <td class="success">${product.pro_id}</td> --%>
								<td class="warning">${product.pro_name }</td>
								<td class="info">${product.price }</td>
								<td class="info">${product.num }</td>
								<td class="info"><img src="/path/upload/${product.img}"
									width="25" height="25" /></td>
								<td class="danger">${product.pro_desc }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				
			</div>
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>