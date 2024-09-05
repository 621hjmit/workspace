<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>메뉴 등록</h3>
<form method="POST" action="/menu/menu-insert" enctype="multipart/form-data">
    <input type="text" id="miName" name="miName" placeholder="메뉴명"><br>
    <input type="text" id="miPrice" name="miPrice" placeholder="가격"><br>
    메뉴 이미지<br>
    <input type="file" id="miPath" name="miPath"><br>
    <button>메뉴 등록</button>
</form>
</body>
</html>