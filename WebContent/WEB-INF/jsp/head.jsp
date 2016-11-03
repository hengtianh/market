
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
				<li class="active"><a href="${pageContext.request.contextPath}/users/home.action">首页<span
						class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">卖家 <span class="glyphicon glyphicon-gift"
						aria-hidden="true"></span><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">在售</a></li>
						<li><a href="#">上架货物</a></li>
						<li><a href="#">我的订单</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" data-toggle="modal" data-target="#cart">购物
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
				</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">用户 <span
						class="glyphicon glyphicon-th-list" aria-hidden="true"></span><span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#myLogin">登录</a></li>
						<li><a href="#" data-toggle="modal" data-target="#myReg">注册</a></li>
						<li><a href="${pageContext.request.contextPath}/users/setting.action">个人设置</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/users/logout.action">退出</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>


<!-- myLogin -->
<div class="modal fade" id="myLogin" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Login Panel</h4>
			</div>
			<div class="modal-body">
				<form id="loginForm" action="${pageContext.request.contextPath}/users/login.action" method="post">
					<div class="form-group">
						<label for="loginEmail1">Email address</label> 
						<input name="email"
							type="email" class="form-control" id="loginEmail1"
							placeholder="Email">
						<span style="color:red;" id="loginnameinfo">${errorUser }</span>
					</div>
					<div class="form-group">
						<label for="loginPassword1">Password</label> 
						<input name="pwd"
							type="password" class="form-control" id="loginPassword1"
							placeholder="Password">
						<span style="color:red;" id="loginpwdinfo"></span>	
					</div>
					<div class="checkbox">
						<label> <input name="checkme" type="checkbox" value="1"> Check me out
						</label>
					</div>
					
					<button id="login" type="button" class="btn btn-success">Login</button>
			</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- myReg -->
<div class="modal fade" id="myReg" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Regist Panel</h4>
			</div>
			<div class="modal-body">
				<form name="reg" action="${pageContext.request.contextPath}/users/regist.action" method="post">
					<div class="form-group">
						<label for="email">Email</label> 
						<input name="email"
							type="email" class="form-control" id="email"
							placeholder="Email">
						<span id="emailinfo" style="color:red;"></span>
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<input name="pwd"
							type="password" class="form-control" id="password"
							placeholder="Password">
						<span id="pwdinfo" style="color:red;"></span>
					</div>
					<div class="form-group">
						<label for="password1">Repeat-Password</label> 
						<input
							type="password" class="form-control" id="password1"
							placeholder="Password">
							<span id="pwd1info" style="color:red;"></span>
					</div>
					
					<label for="inlineRadio1">Gender</label><br/>
					<label class="radio-inline">
						  <input type="radio" name="gender" id="inlineRadio1" value="男" checked="checked"> 男
						</label>
						<label class="radio-inline">
						  <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
						</label>
					
						
					<div class="form-group">
					    <label for="realname">RealName</label>
					    <input name="realName" type="text" class="form-control" id="realname" placeholder="realname">
  						<span id="realNameinfo" style="color:red;"></span>
  					</div>
					<div class="form-group">
					    <label for="phone">Phone</label>
					    <input name="phone" type="text" class="form-control" id="phone" placeholder="phone">
  						<span id="phoneinfo" style="color:red;"></span>
  					</div>
					<div class="form-group">
					    <label for="address">Address</label>
					    <input name="address" type="text" class="form-control" id="address" placeholder="address">
					    <span id="addrinfo" style="color:red;"></span>
  					</div>
  					<button id="subbtn" type="submit" class="btn btn-success" disabled="disabled">Regist</button>
  					
			</div>
			<div class="modal-footer">
				
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 购物车 -->
<!-- Modal -->
<div class="modal fade" id="cart" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Shopping Cart</h4>
			</div>
			<div class="modal-body">
				<div class="media">
					<div class="media-left">
						<a href="#"> <img class="media-object" src="image/6.jpg" width="64" height="64" alt="...">
						</a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">Media heading</h4>
						<p>描述信息</p>
						<input type="number" value="1">　件
						单价：20元
						<a href="#" class="btn btn-danger">删除该项</a>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-dismiss="modal">结算</button>
				<button type="button" class="btn btn-danger">清空购物车</button>
			</div>
		</div>
	</div>
</div>


