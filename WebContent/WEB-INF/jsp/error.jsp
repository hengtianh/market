<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常页面</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
<div class="row"> 
<div class="col-md-4"><img src="${pageContext.request.contextPath}/image/error.jpg" /></div>
<div class="col-md-4">
<p class="text-center" style="margin-top:250px;font-family: 微软雅黑;font-size: 26px;color:#F25C27;">
<c:if test="${message =='该用户还未激活'}">
    您的email尚未验证，点击下面的链接发送激活邮件，查看邮件并激活账号后再试！<br/>
    <a href="${pageContext.request.contextPath}/users/sendMail.action?email=${loginUser.email}&realName=${loginUser.realName }">发送邮件</a>
</c:if>
${message}
${errorUser}
${loginError}
</p>
</div>
<div class="col-md-4"></div>
</div>
</body>
</html>