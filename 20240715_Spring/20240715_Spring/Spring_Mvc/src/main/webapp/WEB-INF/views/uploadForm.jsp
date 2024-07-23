<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
	<h1>동기식 (화면전환o) 파잂첨부 실습</h1>
	<form method="post" action="uploadFormAction" enctype = "multipart/form-data">
		<%-- 
			파일첨부하는 기능을 만들때 주의사항)
			1. 파일 첨부 기능을 만들려면 반드시 method="post"방식으로 해야한다.
			2. form 태그 내에 enctype = "multipart/form-data"를 지정해야 한다.
		 --%>
		 파일첨부 : <input type ="file" name='uploadFile' multiple>
		 <input type = "submit" value="파일업로드" />
	</form>
</body>
</html>