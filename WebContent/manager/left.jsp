<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>左侧导航</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style>
.backleft{ margin-left:50px;}
</style>
</head>

<body>
<div class="backleft">
  <ul class="nav nav-pills nav-stacked">
  <li class=""><a href="#"></a></li>
    <li class="active"><a href="addcategory.jsp" target="mainFrame">类别管理</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/showall" target="mainFrame">文章管理</a></li>
  </ul>
</div>
</body>
</html>
