<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
		.bgcolor{
			background-color:#b3b3b3;
			height: 600px;
		}
		.myform{
			padding:20px;
			margin:150px 0 0 300px;
			width:300px;
			height: 200px;
			/*background-color: #0e90d2;*/
			border:1px solid #e2e2e2;
			border-radius: 10px;
			background-color: #e2e2e2;
			box-shadow: 20px;
		}
	</style>

	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container bgcolor">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<div class="myform">
			<form action="${pageContext.request.contextPath}/adminLogin.action" method="post">
			<div class="form-group">
					<label for="userid"><span style="color:red">${msg}</span></label>
				</div>
				<div class="form-group">
					<label for="username">userID</label>
					<input type="text" name="username" class="form-control form-horizontal" id="userid" placeholder="user ID" required="required">
				</div>
				<div class="form-group">
					<label for="userpass">Password</label>
					<input type="password" name="password" class="form-control" id="userpass" placeholder="Password" required="required">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
</div>
</body>
</html>