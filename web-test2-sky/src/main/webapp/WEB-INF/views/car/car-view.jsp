<%@page import="com.test.web.vo.CarVO"%>
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
CarVO car = (CarVO) request.getAttribute("car");
%>
<form method="post" action="/car/car-delete">
    <input type="hidden" name="ciNum" value="<%=car.getCiNum() %>"> 
	<table border="1">
	    <tr>
	        <th>번호</th>
	        <td><%=car.getCiNum() %></td>
	    </tr>
	    <tr>
	        <th>모델명</th>
	        <td><%=car.getCiName() %></td>
	    </tr>
	    <tr>
	        <th>연식</th>
	        <td><%=car.getCiYear() %></td>
	    </tr>
	
	    <tr>
	        <th colspan="2">
		        <button type="button" onclick="location.href='/car/car-update?ciNum=<%=car.getCiNum()%>'">수정</button>
		        <button>삭제</button>
	        </th>
	    </tr>
	    
	</table>
</form>
<a href="/car/car-list">자동차 전체보기</a>
</body>
</html>