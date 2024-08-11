<%--
  Created by IntelliJ IDEA.
  User: jieunsong
  Date: 8/11/24
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Delete</title>
</head>
<body>
<ul>
<%--    <c:forEach var = "person" items = "member">--%>
        <form method="post" action="/member/memDelete">
            <li>${member.getMemId()}</li>
            <input value="${member.getMemId()}" type="hidden">
            <button value="삭제" type="submit"></button>
        </form>
<%--    </c:forEach>--%>
</ul>

</body>
</html>
