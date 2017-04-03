<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>å¤´é¨</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<style>
body {
	background-color: #000;
}
</style>

</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4">
				<img src="../images/logo.png" width="99" height="35">
			</div>
			<div class="span4 f24black">åå°ç®¡ç</div>
			<div id="time" class="span4 f14black"></div>
		</div>
	</div>
	<script>
	function getTime(){
		var d = new Date();
		var y = d.getYear()+1900;
		var M = d.getMonth()+1;
		var date = d.getDate();
		var h = d.getHours();
		var m = d.getMinutes();
		var s = d.getSeconds();
		var week = d.getDay();
		document.getElementById('time').innerHTML=y+"å¹´"+M+"æ"+date+"æ¥ "+h+":"+m+":"+s+" ææ"+change(week);
		window.setTimeout('getTime()', 1000);
	}
	window.onload=getTime();
	function change(week){
		switch(week){
		case 0:
			return 'æ¥';
		case 1:
			return 'ä¸';
		case 2:
			return 'äº';
		case 3:
			return 'ä¸';
		case 4:
			return 'å';
		case 5:
			return 'äº';
		case 6:
			return 'å­';
		}
	}
</script>
</body>
</html>
