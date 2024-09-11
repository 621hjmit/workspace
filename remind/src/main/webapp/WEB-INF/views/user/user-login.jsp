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
UserVO user = (UserVO) session.getAttribute("user");
if(user!=null){
%>
<%=user.getUiName()%>님 안녕하세요.
<a href="/user/user-list">목록가자</a>
<form method="POST" action="/user/user-logout">
	<button>로그아웃</button>
</form>
<%
}else{
%>

<form method="POST" action="/user/user-login">
	<input type="text" name="uiId" placeholder="아이디"><br>
	<input type="password" name="uiPwd" placeholder="비밀번호"><br>
	<button>로그인</button>
</form>
<%
}
%>
	
</body>
</html>