<%@page import="com.test.web.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
<form action="/board/board-update" method="post">
<input type="hidden" name="biNum" value="<%=board.getBiNum()%>">
<p>
    번호
    <%=board.getBiNum() %>
</p>
<p>
    작성자
    <%=board.getBiAuthor() %>
</p>
<p>
    날짜
    <%=board.getCredat() %>
</p>
<p>
    제목
    <input type="text" name="biTitle" value="<%=board.getBiTitle() %>">
</p>
<p>
    본문
    <input type="text" name="biBody" value="<%=board.getBiBody() %>">
</p>
<p>
    <button>수정</button>
</p>
</form>
<a href="/board/board-list">글 전체 보기</a>
</body>
</html>