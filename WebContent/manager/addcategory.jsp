
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加知识分类</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
  <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/addcategory">
    <fieldset>
      <legend>添加知识类别</legend>
      <div class="control-group">
        <label for="name" class="control-label">类别名称</label>
        <div class="controls">
          <input type="text" id="name" name="name">
        </div>
      </div>
      <div class="control-group">
        <label for="img" class="control-label">类别头像</label>
        <div class="controls">
          <input type="file" id="img" name="img">
        </div>
      </div>
      <div class="control-group">
        <label for="description" class="control-label">类别描述</label>
        <div class="controls">
          <textarea rows="10" cols="20" id="description" name="description"></textarea>
        </div>
      </div>
    </fieldset>
    <div class="form-actions">
      <input type="submit" value="添加" class="btn btn-primary">
    </div>
  </form>
</div>
</body>
</html>