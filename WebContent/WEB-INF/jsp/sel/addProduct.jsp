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
	<script type="text/javascript">
		  function uploadevent(status,picUrl){
		    status += '';
		    switch(status){
		    case '1':
			var filename162 = picUrl+'_162.jpg';
			var filename48 = picUrl+'_48.jpg';
			var filename20 = picUrl+"_20.jpg";
		
			document.getElementById('avatar_priview').innerHTML = "头像1 : <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename162+"'/> <br/> 头像2: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename48+ "'/><br/> 头像3: <img style=\"border-radius:5px;\" src='${pageContext.request.contextPath}/headerimages/"+filename20+ "'/>" ;
			
		    break;
		    case '-1':
		    window.location.reload();
		    break;
		    default:
		    window.location.reload();
		   } 
		  }
	</script>
</head>
<body style="background-color:#232830;height:700px;">

<div class="container" style="background-color:white;">
<!-- head页面 -->
<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
<div style="height:400px;">
<div class="row">
		<div class="col-md-3">
		<!-- Nav tabs -->
		  <div>
			  <ul class="nav nav-tabs nav-stacked" role="tablist">
			    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">上架商品</a></li>
			    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">添加图片</a></li>
			    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">在售商品</a></li>
			    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">其他内容</a></li>
			  </ul>
		  </div>	
		</div>

		<div class="col-md-9">
			<!-- 添加基本信息 -->
		  <div class="tab-content col-md-8">
		    <div role="tabpanel" class="tab-pane active" id="home">
		    	<form action="${pageContext.request.contextPath}/category/addProduct.action" method="post" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${sessionScope.user.id}">
				<div class="form-group">
					<label for="cateitem">cateitem</label>
					<select class="form-control" name="cateitem">
					<c:forEach var="item" items="${requestScope.items}">
						<option value="${item.id}">${item.itemName}</option>
					</c:forEach>
				</select>
				</div>
				
				<div class="form-group">
					<label for="pro_name">pro_name</label>
					<input name="pro_name" value=""
					type="text" class="form-control" id="pro_name" placeholder="pro_name">
				</div>
				
				<div class="form-group">
					<label for="pro_desc">pro_desc</label>
					<input name="pro_desc" value=""
					type="text" class="form-control" id="pro_desc" placeholder="pro_desc">
				</div>
				
				<div class="form-group">
					<label for="price">price</label>
					<input name="price" value=""
					type="text" class="form-control" id="price" placeholder="price">
				</div>
				
				<div class="form-group">
				    <label for="file">product image</label>
				    <input type="file" id="file" name="proImg">
				    <p class="help-block">在这里添加商品的图片</p>
				</div>
				
				<div class="form-group">
					<label for="num">num</label>
					<input name="num" value=""
					type="number" min="1" class="form-control" id="num" placeholder="num">
				</div>

				<button type="submit" class="btn btn-primary">添加</button>
				<div class="form-group">
					<label for="phone"></label>
					<!-- <input type="text" class="form-control" id="address" placeholder="address"> -->
				</div>
			</form>
		    </div>
		    
		    <!-- 图片上传组件 -->
		    <div role="tabpanel" class="tab-pane" id="profile">
				<table width="80%" border="1" cellspacing="0" cellpadding="0">
				  <tr>
				    <td width="200" valign="top"><div id="avatar_priview"></div></td>
				    <td>
				    <div id="altContent">
					  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0" width="650" height="450" id="myMovieName">
					    <param name="movie" value="${pageContext.request.contextPath}/upload/avatar.swf"/>
					    <param name="quality" value="high"/>
					    <param name="bgcolor" value="#FFFFFF"/>
					    <param name="flashvars" value="imgUrl=${pageContext.request.contextPath}/upload/default.jpg&uploadUrl=${pageContext.request.contextPath}/upload/upfile.jsp&uploadSrc=false" />
					    <embed src="${pageContext.request.contextPath}/upload/avatar.swf" quality="high" bgcolor="#FFFFFF" width="650" height="450" wmode="transparent" flashVars="imgUrl=${pageContext.request.contextPath}/upload/default.jpg&uploadUrl=upload/upfile.jsp&uploadSrc=false" name="myMovieName" align="" type="application/x-shockwave-flash" allowScriptAccess="always" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>
					  </object>
					</div>
					</td>
				  </tr>
				</table>
			</div>
		    
		    <div role="tabpanel" class="tab-pane" id="messages">
		    	<%-- <jsp:include page="/WEB-INF/jsp/p_list.jsp"></jsp:include> --%>
				<table class="table-hover" width="800px" border="1" align="center" cellpadding="0" cellspacing="0">
				  <tr align="center">
				    <td class="active">id</td>
				    <td class="warning">名称</td>
				    <td class="info">单价</td>
				    <td class="info">库存</td>
				    <td class="info">图片</td>
				    <td class="danger">描述</td>
				    <td class="danger">操作</td>
				  </tr>
				 <c:forEach items="${pl}" var="product">
				<tr align="center">
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
		    <div role="tabpanel" class="tab-pane" id="settings">其他项目</div>	
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