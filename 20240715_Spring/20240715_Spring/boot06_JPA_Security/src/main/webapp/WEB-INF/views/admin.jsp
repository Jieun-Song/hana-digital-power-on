<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type ="text/css" href ="./css/member.css"/>
<title> </title>
</head>
<body>
<!-- 로그인 이후 admin 화면 -->
<div id="Index_wrap">
	<h1 class = "title_size">/admin for admin</h1>
	
	<h2 class = "Index_title">로그인 이후 메인화면</h2>
	<table id = "Index_t">
		<tr>
			<th><input type = "button" value = "정보수정"/><input type = "button" value="로그아웃" 
				onclick="location='logout';"/></th>
		</tr>
		<tr>
			<th>'${id}'님으로 로그인한 "${name}"님 환영합니다!</th>
		</tr>
		<tr>
			<th> <a href = "#">Admin 페이지</a></th>
		</tr>
	</table>
</div>
</body>
</html>