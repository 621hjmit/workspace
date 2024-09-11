<%@page import="com.remind.test.vo.CarVO"%>
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
<form action="/car/car-list">
	<input type="text" name="ciNum" placeholder="번호">
	<input type="text" name="ciName" placeholder="모델명">
	<button>검색</button>
</form>
<%
List<CarVO> cars = (List<CarVO>) request.getAttribute("cars");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>모델명</th>
	</tr>
<%
for(CarVO car:cars){
%>
	<tr>
		<td><%=car.getCiNum()%></td>
		<td><a href="/car/car-view?ciNum=<%=car.getCiNum()%>"><%=car.getCiName()%></a></td>
	</tr>
<%
}
%>
</table>
<button onclick="location.href='/views/car/car-insert'">차량등록</button>
</body>
</html>