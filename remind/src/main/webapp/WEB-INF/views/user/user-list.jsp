<%@page import="com.remind.test.vo.UserVO"%>
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
<%
UserVO loginUser = (UserVO) session.getAttribute("user");
if(loginUser!=null){
%>
	<%=loginUser.getUiName()%>님 안녕하세요.
<%
}
%>
<form action="/user/user-list">
	<input type="text" name="uiNum"  placeholder="번호">
	<input type="text" name="uiName" placeholder="이름">
	<input type="text" name="uiId" placeholder="아이디">
	<button>검색</button>
</form>

<%
List<UserVO> users = (List<UserVO>) request.getAttribute("users");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
	</tr>
<%
for(UserVO user:users){
%>
	<tr>
		<td><%=user.getUiNum()%></td>
		<td><%=user.getUiName()%></td>
		<td><a href="/user/user-view?uiNum=<%=user.getUiNum()%>"><%=user.getUiId()%></a></td>
	</tr>
<%
}
%>
</table>
<button onclick="location.href='/views/user/user-insert'">회원가입</button>
<button onclick="location.href='/user/user-list'">전체보기</button>
<%
if(loginUser!=null){
%>
	<form method="POST" action="/user/user-logout">
		<button>로그아웃</button>
	</form>
<%}else{ %>
	<button onclick="location.href='/views/user/user-login'">로그인</button>
<%} %>
</body>
</html>