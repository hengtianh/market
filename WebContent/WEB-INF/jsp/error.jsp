<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常页面</title>
</head>
<body>
<c:if test="${message =='该用户还未激活'}">
	您的email尚未验证，点击下面的链接发送激活邮件，查看邮件并激活账号后再试！<br/>
	<a href="${pageContext.request.contextPath}/users/sendMail.action?email=${loginUser.email}&realName=${loginUser.realName }">发送邮件</a>
</c:if>
${message }
${errorUser }
</body>
</html>