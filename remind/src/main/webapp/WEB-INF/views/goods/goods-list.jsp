<%@page import="com.remind.test.vo.GoodsVO"%>
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
<form action="/goods/goods-list">
	<input type="text" name="giNum" placeholder="번호">
	<input type="text" name="giName" placeholder="상품명">
	<button>검색</button>
</form>
<%
List<GoodsVO> list = (List<GoodsVO>) request.getAttribute("list");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>모델명</th>
	</tr>
<%
for(GoodsVO goods:list){
%>
	<tr>
		<td><%=goods.getGiNum()%></td>
		<td><a href="/goods/goods-view?giNum=<%=goods.getGiNum()%>"><%=goods.getGiName()%></a></td>
	</tr>
<%
}
%>
</table>
<button onclick="location.href='/views/goods/goods-insert'">상품등록</button>
</body>
</html>