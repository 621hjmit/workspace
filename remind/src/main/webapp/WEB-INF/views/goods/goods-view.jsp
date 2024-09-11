<%@page import="com.remind.test.vo.GoodsVO"%>
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
GoodsVO goods = (GoodsVO)request.getAttribute("goods");
%>
<table border="1">
	<tr>
		<th>모델번호</th>
		<td><%=goods.getGiNum() %></td>
	</tr>
	<tr>
		<th>모델명</th>
		<td><%=goods.getGiName() %></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><%=goods.getGiPrice() %></td>
	</tr>
	<tr>
		<th>설명</th>
		<td><%=goods.getGiDesc() %></td>
	</tr>
	<tr>
		<th colspan="2"><button onclick="location.href='/goods/goods-update?giNum=<%=goods.getGiNum()%>'">수정</button></th>
	</tr>
</table>
</body>
</html>