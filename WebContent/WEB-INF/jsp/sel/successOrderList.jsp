<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mystyle.css"
	rel="stylesheet">
	
	<style type="text/css">
#tablebg {
    background: url('${pageContext.request.contextPath}/image/bg3.jpg')
        no-repeat;
    height: 640px;
}
</style>
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
		
		<div id="tablebg">
        <div class="row">
          <div class="col-md-12">
              <ol class="breadcrumb">
                  <li><a href="#">首页</a></li>
                  <li class="active">已发货</li>
              </ol>
          </div>
        </div>
		<div class="row">
            <div class="col-md-3" style="padding-top: 50px;">
                <div class="main-left">
                    <div class="main-nav"></div>
                </div>
            </div>

            <div class="col-md-7" style="padding-top: 50px;">

                <div class="panel panel-default">
                    <div class="panel-heading">已发货订单</div>
                    <div class="panel-body">
                        <table class="table table-hover" width="800px" border="0" cellpadding="0"
                        cellspacing="0">
                        <tr align="center">
                            <td class="info">商品名称</td>
                            <td class="info">单价</td>
                            <td class="info">数量</td>
                        </tr>
                        <c:forEach items="${sodl}" var="od">
                            <tr align="center">
                                <td class="success">${od.pName}</td>
                                <td class="warning">${od.price}</td>
                                <td class="info">${od.num }</td>
                            </tr>
                        </c:forEach>
                    </table>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
        </div>
		
		
		</div>
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/validate.js"></script>
    <script src="${pageContext.request.contextPath}/js/category.js"></script>
    <script>
        function showNav(value) {
            var index = value + 1;
            var div = document.getElementById('nav' + index);
            $(div).toggle('blind');
        }
    </script>
</body>
</html>