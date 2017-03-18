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
		<div class="row" style="height: 640px;">
			<div class="col-md-3" style="margin-top: 50px;">
				<!-- Nav tabs -->
				<div>
					<ul class="nav nav-tabs nav-stacked" role="tablist">
						<li role="presentation"><a href="#messages"
							aria-controls="messages" role="tab" data-toggle="tab">订单支付</a></li>
					</ul>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="messages"
				style="margin-top: 50px;">
				<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
				<form
					action="${pageContext.request.contextPath}/order/pay.action"
					method="post">
					<table class="table-hover" width="750px" border="1" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td colspan="4" class="warning">订单编号：<input type="text"
								name="ordersnum" value="${ods.oid}" readonly="readonly" />
							</td>
						</tr>
						<tr align="center">
							<td class="active" width="300">id</td>
							<td class="info" width="150">名称</td>
							<td class="info" width="100">单价</td>
							<td class="info" width="100">数量</td>
						</tr>
						<c:forEach items="${ods.od}" var="product">
							<tr align="center">
								<td class="active">${product.pId}</td>
								<td class="warning">${product.pName}</td>
								<td class="info">${product.price}</td>
								<td class="info">${product.num}</td>
							</tr>
						</c:forEach>
						<tr align="right">
							<td colspan="4" class="info">支付金额：<input type="text"
								name="price" value="${ods.total}" readonly="readonly" />元
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr align="center">
							<td colspan="4">
								<table>
									<tr align="center">
										<td colspan="4">请您选择在线支付银行</td>
									</tr>
									<tr style="margin:10px 10px;">
										<td><INPUT TYPE="radio" NAME="pd_FrpId"
											value="CMBCHINA-NET"><img alt=""
											src="${pageContext.request.contextPath}/image/CMBCHINA-NET.png">
										</td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="ICBC-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/ICBC-NET.png"></td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="ABC-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/ABC-NET.png"></td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="CCB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/CCB-NET.png">
										</td>
									</tr>
									<tr>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBC-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/CMBC-NET.gif"></td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="CEB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/CEB-NET.jpg">
										</td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="BOCO-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/BOCO-NET.png"></td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="SDB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/SDB-NET.png"></td>
									</tr>
									<tr>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="BCCB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/BCCB-NET.png"></td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="CIB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/CIB-NET.png">
										</td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId" value="SPDB-NET"><img
											alt=""
											src="${pageContext.request.contextPath}/image/SPDB-NET.png">
										</td>
										<td><INPUT TYPE="radio" NAME="pd_FrpId"
											value="ECITIC-NET"><img alt=""
											src="${pageContext.request.contextPath}/image/ECITIC-NET.png"></td>
									</tr>
									<tr align="center">
										<td colspan="4"><INPUT TYPE="submit" value="确定支付"></td>
									</tr>
								</table>
									</td>
									</tr>
					</table>
				</form>
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