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
<script type="text/javascript">
	
</script>
</head>
<body style="background-color: #232830;">
	<div class="container" style="background-color: white;">
		<!-- head页面 -->
		<jsp:include page="/WEB-INF/jsp/manager/head.jsp"></jsp:include>
		<div id="tablebg">
		<div class="row">
          <div class="col-md-12">
              <ol class="breadcrumb">
                  <li><a href="#">首页</a></li>
                  <li class="active">上架商品</li>
              </ol>
          </div>
        </div>
		<div class="row" style="height: 640px;">
			<div class="col-md-3" style="margin-top: 50px;">
				<!-- Nav tabs -->
				<div>
					<ul class="nav nav-tabs nav-stacked" role="tablist">
						<li role="presentation" class="active"><a href="#home"
							aria-controls="home" role="tab" data-toggle="tab">新增类别</a></li>
					</ul>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="messages"
				style="margin-top: 50px;">
				<div class="tab-content col-md-8">
					<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
					<table class="table-hover" width="200px" border="1" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<form
								action="${pageContext.request.contextPath}/category/addCategory.action"
								method="post">

								<div class="form-group">
									<label for="pro_name">子类别id</label><select
                                            class="form-control" name="category">
                                            <c:forEach var="c" items="${category}">
                                                <option value="${c.cate_id}">${c.cate_name}</option>
                                            </c:forEach>
                                        </select>
								</div>

								<div class="form-group">
									<label for="pro_desc">子类别名称</label>
									 <input name="itemName"
                                        value="" type="text" class="form-control" id="cate_id"
                                        placeholder="itemName">
								</div>
								
								<div class="form-group">
									<label for="cate_desc">类别描述</label> <input name=""
										value="" type="text" class="form-control" id="cate_desc"
										placeholder="cate_desc">
								</div>

								<button type="submit" class="btn btn-primary">添加</button>
								<div class="form-group">
									<label for="phone"></label>
								</div>
							</form>
						</tr>
					</table>
				</div>
			</div>

		</div>
	</div>
	</div>
	<!-- foot页面 -->
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>

	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>