<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<%-- jsp 주석문 기호, jQuery CDN 방식  --%>
<script type ="text/javascript">
	function check(){//function 키워드로 check()함수를 정의

		if($.trim($('#title').val())==''){
			alert('글제목을 입력하세요!');
			$('#title').val('').focus();
			return false;
		}
		
		if($.trim($('#cont').val()).length == 0){
			alert('글내용을 입력하세요!');
			$('#cont').val('').focus();
			return false;
		}
		
	}
</script>
</head>
<body>
<form method = "post" action = "test_write_ok" onsubmit="return check();">
	<label for="title">제목</label>
	<input type = "text" name = "title" size= "14" id = "title" placeholder="제목 입력"/>
	<br/>
	<label for="cont">내용</label>
	<input type = "text" name = "cont" rows = "10" cols= "34" id = "cont" placeholder="제목 입력"/>
	<br/>
	<input type="submit" value = "입력">
</form>
</body>
</html>