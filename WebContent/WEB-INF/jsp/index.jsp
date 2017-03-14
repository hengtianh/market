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
				<div class="main-left">
					<div class="main-nav"></div>
				</div>
			</div>

			<div class="col-md-9" id="messages"
				style="margin-top: 50px;">
				<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
				<div class="row">
					<c:forEach items="${products}" var="p">
						<form
							action="${pageContext.request.contextPath}/order/addCart.action"
							method="post">
							<input type="hidden" name="id" value="${p.pro_id}" /> <input
								type="hidden" name="info" value="${p.pro_name}" /> <input
								type="hidden" name="price" value="${p.price}" />
							<div class="col-md-4">
								<div class="thumbnail">
									<a
										href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}"><img
										src="/path/upload/${p.img}" alt="..." width="168" height="198"></a>
									<div class="caption">
										<h3>${p.pro_name}</h3>
										<p>${p.pro_desc}</p>
										<p>
											<input type="submit" class="btn btn-primary" role="button"
												value="加入购物车"> <a
												href="${pageContext.request.contextPath}/category/showDetail.action?pro_id=${p.pro_id}"
												class="btn btn-default" role="button">查看信息</a>
										</p>
									</div>
								</div>
							</div>
					</c:forEach>
					</form>
				</div>

				<!-- 分页的导航条 -->
				<div class="container row">
					<div class="col-md-offset-3 col-md-7">
						<nav>
							<ul class="pagination">
								<li><a
									href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${pageOrder.pages[0]<=1?1:pageOrder.pages[0]-1}&type=${pageOrder.type}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="page" items="${pageOrder.pages}">
									<li><a
										href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${page}&type=${pageOrder.type}">${page}</a></li>
								</c:forEach>
								<!-- 下一页 -->
								<%-- <c:if test=""> --%>
								<li><a
									href="${pageContext.request.contextPath}/page/getPage.action?pageIndex=${pageOrder.pages[pageOrder.size-1]>=pageOrder.pageCount?pageOrder.pageCount:pageOrder.pages[pageOrder.size-1]+1}&type=${pageOrder.type}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
								<%-- </c:if> --%>
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

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
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