<%@page import="com.remind.test.vo.UserVO"%>
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
UserVO user = (UserVO)request.getAttribute("user");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=user.getUiNum() %></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=user.getUiName() %></td>
	</tr>
	<tr>
		<th>아이디</th>
		<td><%=user.getUiId() %></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><%=user.getUiPwd() %></td>
	</tr>
	<tr>
		<th colspan="2"><button onclick="location.href='/user/user-update?uiNum=<%=user.getUiNum()%>'">수정</button></th>
	</tr>
</table>
</body>
</html>