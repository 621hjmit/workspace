<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%=1+1+"2" %>
<%
String str = "정말 이래도 괜찮을까???!!?? 난 걱정이...";
%>
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
        <th>작성자</th>
        <th>작성일</th>
    </tr>
    <tr>
        <td>1</td>
        <td><%=str%></td>
        <td>박경훈</td>
        <td>2024-08-26</td>
    </tr>
</table>
</body>
</html>