<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
    <form method="post" action="/login">
        <input type="text" id="id">
        <input type="text" id="pw">
        <input type="submit" value="login"/>
    </form>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <h3>로그인되었습니다.</h3>
</sec:authorize>


</body>
</html>
