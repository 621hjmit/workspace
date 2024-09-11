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
<form method="POST" action="/goods/goods-update" id="frm">
	<input type="hidden" name="giNum" value="<%=goods.getGiNum()%>">
	<table border="1">
		<tr>
			<th>상품 번호</th>
			<td><%=goods.getGiNum() %></td>
		</tr>
		<tr>
			<th>모델명</th>
			<td><input type="text" name="giName" value="<%=goods.getGiName()%>"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="giPrice" value="<%=goods.getGiPrice()%>"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><input type="text" name="giDesc" value="<%=goods.getGiDesc()%>"></td>
		</tr>
		<tr>
			<th colspan="2"><button>수정</button> <button type="button" onclick="changeAction(this.form)">삭제</button></th>
		</tr>
	</table>
</form>
<script>
function changeAction(frm){
	frm.action='/goods/goods-delete';
	frm.submit();
}
</script>
</body>
</html>