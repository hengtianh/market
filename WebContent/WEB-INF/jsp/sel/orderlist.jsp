<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
<div class="col-md-9">
<table class="table table-hover">
  <tr>
  <td class="active">id</td>
  <!-- <td class="success">pro_id</td> -->
  <td class="warning">订单编号</td>
  <td class="info">商品名称</td>
  <td class="info">单价</td>
  <td class="info">数量</td>
  <td class="danger">状态</td>
  <td class="info">操作</td>
</tr>
<c:forEach items="${ods}" var="od">
<tr>
  <td class="active">${od.orderid}</td>
  <td class="success">${od.info}</td>
  <td class="warning">${od.price}</td>
  <td class="info">${od.num }</td>
  <td class="info">${od.success }</td>
  <td class="danger">发货</td>
</tr>
</c:forEach>
</table>
</div>
</div>
