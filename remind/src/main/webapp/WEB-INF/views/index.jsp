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
<%
}else{
%>
<a href="/views/user/user-login">로그인</a>을 하셔야 원할한 서비스를 제공 받으실 수 있습니다.
<%
}
%>
<a href="/car/car-list">차 리스트</a><br>
<a href="/goods/goods-list">상품 리스트</a><br>
<a href="/user/user-list">유저 리스트</a>
</body>
</html>