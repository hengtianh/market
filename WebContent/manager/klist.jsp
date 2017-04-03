
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<style>
 a{ text-decoration: none;}
</style>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
  
  <c:if test="${requestScope.knowledgelist!=null}">
  <c:forEach var="k" items="${requestScope.knowledgelist}">
  <tr>  
    <td colspan="3" class="f14white">&nbsp;</td>
  </tr>
  <tr>
    <td width="23" align="center" rowspan="2"><input type="checkbox" id="${k.id }" name="know" value="${k.id }" /></td>
    <td width="80" rowspan="2" align="center" bgcolor="#F3F3F3"><img src="headerimages/userdefault.gif" width="80" height="80"></td>
    <td width="754" class="f14white"><a href="${pageContext.request.contextPath}/showdetails?id=${k.id }">　　${k.title }</a></td>
  </tr>
  <tr>
    <td colspan="5">　　${k.pubDate } 由 ${k.entity.userName }  发布到  ${k.category.name}</td><td width="150" colspan="9"><c:if test="${k.state==1}"><button type="button" class="btn btn-success" disabled='disabled'>已屏蔽</button></c:if><c:if test="${k.state==0}"><a href="${pageContext.request.contextPath}/cover?id=${k.id}" class="btn btn-danger">屏蔽</a></c:if></td>
  </tr>
  	
  </c:forEach>
  <tr>
  	<td width="23"></td>
    <td width="80"></td>
    <td align="right" width="700">
    	<form name="form1" method="post" action="DeleteAll">
    	 <tr>
		  	<td><input type="hidden" id="ids" name="ids" value="" /></td>
		 </tr>
		    	 全选:
    	<input type="checkbox" id="allknow" name="allknow" onclick="checkAll(this.checked)" value="" />
      		<label for="checkbox"></label>
    	</form></td>
    <td width="154" align="right"><button type="submit" class="btn btn-primary" onclick="return delAll()">删除</button></td>
  </tr>
<!--   <tr>
  	<td width="75" align="center"></td>
    <td width="82" rowspan="2" align="center" bgcolor="#F3F3F3">全选:<input type="checkbox" id="allknow" name="allknow" onclick="checkAll(this.checked)" value="" /></td>
    <td width="800" class="f14white"><button type="submit" class="btn btn-primary">屏蔽</button></td>
  </tr> -->
 
  </c:if>
  <c:if test="${requestScope.knowledgelist==null}">
  <tr>
    <td height="40" class="f14white">　还没有人发布知识</td>
  </tr>
  </c:if>
</table>
<script type="text/javascript">
	function checkAll(checked){
		var ids=''; 
		var knows = document.getElementsByName('know');
		if(checked){
			for(var i=0; i<knows.length; i++){
				knows[i].checked = true;
				if(i<1){
					//alert(knows[i].value);
					ids+=knows[i].value;
				}else{
					ids+=','+knows[i].value;
				}
			}
			document.getElementById('ids').value=ids;
		}else{
			for(var i=0; i<knows.length; i++){
				knows[i].checked = false;
			}
		}
	}
	function delAll(){
		var value = document.getElementById('ids').value;
		if(value.length>0){
			document.form1.submit();
		}else{
			alert('还没有选择要删除的知识');
			return false;
		}
	}
</script>
</body>
</html>