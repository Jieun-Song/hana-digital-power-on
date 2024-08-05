<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>home</title>
    <script>

    </script>
</head>
<body>
<form method="post" action="join_new()">
    <label for="nickname">별명</label>
    <input id="nickname">
    <label for="username">아이디</label>
    <input id="username">
    <input type="button" value="아이디 중복체크" formaction="check_id()">
<%--    아이디 중복 확인 해야댐--%>
    <label for="password">비밀번호</label>
    <input id="password">
    <label for="password_chk">비밀번호 확인</label>
    <input id="password_chk">

    <input type="submit" value="회원가입">
</form>
</body>
</html>