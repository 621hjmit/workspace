<%@page import="com.test.web.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>날짜</th>
    </tr>
<%
List<BoardVO> boards = (List<BoardVO>) request.getAttribute("boards");
for(BoardVO board : boards){
%>
    <tr>
        <td><%=board.getBiNum() %></td>     
        <td><a href="/board/board-view?biNum=<%=board.getBiNum()%>"><%=board.getBiTitle() %></a></td>     
        <td><%=board.getBiAuthor() %></td>
        <td><%=board.getCredat() %></td>     
    </tr>
<%} %>
</table>
<a href="/views/board/board-insert">글쓰기</a>
</body>
</html>