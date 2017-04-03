<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>后台首页</title>
</head>
<frameset rows="40,*" cols="*" frameborder="NO" border="0" framespacing="0">
  <frame src="manager/top.jsp" name="topFrame" scrolling="NO" noresize title="topFrame">
  <frameset rows="*" cols="150,*" framespacing="0" frameborder="NO" border="0">
    <frame src="manager/left.jsp" name="leftFrame" scrolling="NO" noresize title="leftFrame">
    <frame src="manager/main.jsp" name="mainFrame" title="mainFrame">
  </frameset>
</frameset><noframes></noframes>

</html>
