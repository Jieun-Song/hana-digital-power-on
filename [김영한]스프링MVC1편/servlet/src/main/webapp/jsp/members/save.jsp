<%@ page import="hello.servlet.domain.MemberRepository" %>
<%@ page import="hello.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response 사용가능(그냥 쓰면 됨.)
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("Member.SaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
    <ul>
        <li>id = <%=member.getId()%></li>
        <li>username = <%=member.getUsername()%></li>
        <li>age = <%=member.getAge()%></li>
    </ul>
    <a href="/index.html">메인</a>
</body>
</html>
