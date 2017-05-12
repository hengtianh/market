<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>Bootstrap 101 Template</title>
	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/mystyle.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
#tablebg {
    background: url('${pageContext.request.contextPath}/image/bg3.jpg')
        no-repeat;
    height: 640px;
}
</style>
</head>
<body style="background-color:#232830;">

<div class="container" style="background-color:white;">
<!-- head页面 -->
<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
<div id="tablebg">
<div class="row">
          <div class="col-md-12">
              <ol class="breadcrumb">
                  <li><a href="#">首页</a></li>
                  <li class="active">个人设置</li>
              </ol>
          </div>
        </div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
		 	<div class="panel-body">
		    	修改个人设置
		  	</div>
			</div>
			<form action="${pageContext.request.contextPath}/users/modifySetting.action" method="post">
				<input type="hidden" name="id" value="${sessionScope.user.id}">
				<input type="hidden" name="pwd" value="${sessionScope.user.pwd}">
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<input name="email" value="${sessionScope.user.email}"
					type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">realName</label>
					<input  name="realName" value="${sessionScope.user.realName}"
					type="text" class="form-control" id="exampleInputPassword1" placeholder="realName">
				</div>
				
				<label for="inlineRadio1">Gender</label><br/>
					<label class="radio-inline">
					<c:if test="${sessionScope.user.gender=='男'}">
						<input type="radio" name="gender" id="inlineRadio1" value="男" checked="checked"> 男
					</c:if>
					<c:if test="${sessionScope.user.gender!='男'}">
						<input type="radio" name="gender" id="inlineRadio1" value="男"> 男
					</c:if>
						</label>
						<label class="radio-inline">
					<c:if test="${sessionScope.user.gender=='女'}">
						<input type="radio" name="gender" id="inlineRadio1" value="女" checked="checked"> 女
					</c:if>
					<c:if test="${sessionScope.user.gender!='女'}">
						<input type="radio" name="gender" id="inlineRadio1" value="女"> 女
					</c:if>
				</label>
				
				<div class="form-group">
					<label for="phone">phone</label>
					<input name="phone" value="${sessionScope.user.phone}"
					type="text" class="form-control" id="phone" placeholder="phone">
				</div>
				<div class="form-group">
					<label for="phone">address</label>
					<input name="address" value="${sessionScope.user.address}"
					type="text" class="form-control" id="address" placeholder="address">
				</div>

				<button type="submit" class="btn btn-primary">修改</button>
				<div class="form-group">
					<label for="phone"></label>
					<!-- <input type="text" class="form-control" id="address" placeholder="address"> -->
				</div>
			</form>
		</div>
	</div>
</div>
</div>

<!-- foot页面 -->
<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>