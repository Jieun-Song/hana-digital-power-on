<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th colspan="5"> 첫째주 과제 - 공지 목록 </th>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>조회수</th>
			<th>올린날짜</th>
		</tr>
		<c:if test="${!empty glist}">
			<c:forEach var="g" items = "${glist}">
				<tr>
					<th>${g.no}
					<th>
						<a href = "/gongji/gongji_cont?no=${g.no}&state=cont">${g.title}</a>
					</th>
					<th>${g.name}</th>
					<th>${g.hit}</th>
					<th>${g.date}</th>
				</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${empty glist}">
		   <tr>
		     <th colspan="5">목록에 글이 없습니다!</th>
		   </tr>
		</c:if>
		<tr>
		  <td colspan="5" align="right">
		   <input type="button" value="글쓰기" onclick="location='/board/board_write?page${page}';" />
		   <%-- board_write?page=쪽번호를 get방식으로 전달한다. --%>
		  </td>
		 </tr>
	</table>
</body>
</html>

