<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<div class="col-md-9">
<table class="table table-hover">
  <tr>
  <td class="active">id</td>
  <!-- <td class="success">pro_id</td> -->
  <td class="warning">名称</td>
  <td class="info">单价</td>
  <td class="info">库存</td>
  <td class="info">图片</td>
  <td class="danger">描述</td>
  <td class="info">操作</td>
</tr>
<c:forEach items="${pl}" var="product">
<tr>
  <td class="active">${product.id}</td>
  <%-- <td class="success">${product.pro_id}</td> --%>
  <td class="warning">${product.pro_name }</td>
  <td class="info">${product.price }</td>
  <td class="info">${product.num }</td>
  <td class="info"><img src="/path/upload/${product.img}" width="25" height="25" /></td>
  <td class="danger">${product.pro_desc }</td>
</tr>
</c:forEach>
</table>
</div>
</div>
