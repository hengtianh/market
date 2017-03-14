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
							<li role="presentation"><a href="#settings"
							aria-controls="settings" role="tab" data-toggle="tab">已发货订单</a></li>
						</ul>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="settings" style="margin-top:50px;">
					<table class="table-hover" width="800px" border="1" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td class="info">商品名称</td>
							<td class="info">单价</td>
							<td class="info">数量</td>
						</tr>
						<c:forEach items="${sodl}" var="od">
							<tr align="center">
								<td class="success">${od.pName}</td>
								<td class="warning">${od.price}</td>
								<td class="info">${od.num }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
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