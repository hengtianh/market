<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="welcome">welcome to the market!</div>
<div class="market">
	<p>Market Online!</p>
	<hr>
</div>
<nav class="navbar navbar-default navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Market Online</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/category/toIndex.action">首页<span
						class="sr-only">(current)</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/order/findMyOrderDetail.action">我的宝贝</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">卖家 <span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/category/showMyProducts.action?userid=${sessionScope.user.id}">在售</a></li>
						<li><a
							href="${pageContext.request.contextPath}/category/product/toAddProduct.action">上架货物</a></li>
						<li><a
							href="${pageContext.request.contextPath}/order/findOrderDetailSell.action">待发货订单</a></li>
						<li><a
							href="${pageContext.request.contextPath}/order/successOrderList.action">已发货订单</a></li>
						<!-- <li role="separator" class="divider"></li> -->

					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search"
				action="${pageContext.request.contextPath}/category/search.action"
				method="post">
				<div class="form-group">
					<input type="text" name="label" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#" data-toggle="modal" data-target="#cart">购物车
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
				</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">用户 <span
						class="glyphicon glyphicon-th-list" aria-hidden="true"></span><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#myLogin">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/users/toRegister.action">注册</a></li>
						<li><a
							href="${pageContext.request.contextPath}/users/setting.action">个人设置</a></li>
						<li role="separator" class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/users/logout.action">退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>


<!-- myLogin -->
<div class="modal fade" id="myLogin" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">用户登录</h4>
			</div>
			<div class="modal-body" id="loginForm">
			<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form id="loginForm"
					action="${pageContext.request.contextPath}/users/login.action"
					method="post">
					<div class="form-group">
						<label for="loginEmail1">Email 地址</label> <input name="email"
							type="email" class="form-control" id="loginEmail1"
							placeholder="Email"> <span style="color: red;"
							id="loginnameinfo">${errorUser }</span>
					</div>
					<div class="form-group">
						<label for="loginPassword1">密码</label> <input name="pwd"
							type="password" class="form-control" id="loginPassword1"
							placeholder="Password"> <span style="color: red;"
							id="loginpwdinfo"></span>
					</div>
					<div class="checkbox">
						<label> <input name="checkme" type="checkbox" value="1">
							Check me out
						</label>
					</div>

					<button id="login" type="submit" class="btn btn-success">Login</button>
			<div class="modal-footer">

				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
			</div>
			</form>
			<div class="col-md-2"></div>
			</div>
			</div>
		</div>
	</div>
</div>
<!-- 购物车 -->
<!-- Modal -->
<div class="modal fade bs-example-modal-md" id="cart" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content modal-md">
			<div class="modal-header">

				<h4 class="modal-title" id="myModalLabel">购物车</h4>
			</div>
			<div class="modal-body">
				<c:if test="${cart == null or cart.cartItems.size()<=0}">
				购物车空空如也!
			</c:if>
				<table class="table-condensed">
					<c:forEach items="${cart.cartItems}" var="cart">
						<tr>
							<td class="active"><span>${cart.info}</span></td>
							<td class="success">${cart.num}</td>
							<td class="warning">单价：${cart.price}元</td>
							<td class="danger"><a
								href="${pageContext.request.contextPath}/order/removeItem.action?id=${cart.id}&price=${cart.price}"
								class=""><span class="glyphicon glyphicon-remove"
									aria-hidden="true"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="modal-footer">
				<a
					href="${pageContext.request.contextPath}/order/createOrder.action"
					class="btn btn-success">结算</a> <a
					href="${pageContext.request.contextPath}/order/removeCart.action"
					class="btn btn-danger">清空购物车</a>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		//$("[data-toggle='popover']").attr('data-content','<h1>aaa</h1>');
		$("[data-toggle='popover']").popover();
	});
</script>

