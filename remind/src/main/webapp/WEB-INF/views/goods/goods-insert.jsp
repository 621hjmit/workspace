<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품등록</h3>
<form method="POST" action="/goods/goods-insert">
	<input type="text" name="giName" placeholder="모델명"><br>
	<input type="text" name="giPrice" placeholder="가격ㄴ"><br>
	<input type="text" name="giDesc" placeholder="설명"><br>
	<button>등록</button>
</form>
</body>
</html>