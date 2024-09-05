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
<form method="post" action="/car/car-update">
	<table border="1">
	    <tr>
	        <th>번호</th>
	        <td>
		        <%=car.getCiNum() %>
		        <input type="hidden" id="ciNum" name="ciNum" value="<%=car.getCiNum() %>">
	        </td>
	   </tr>
	   <tr>
	       <th>모델명</th>
	       <td><input type="text" id="ciName" name="ciName" value="<%=car.getCiName() %>"></td>
	   </tr>
	   <tr>
	       <th>연식</th>
	       <td><input type="text" id="ciYear" name="ciYear" value="<%=car.getCiYear() %>"></td>
	    </tr>
	
	    <tr>
	        <th colspan="2"><button>수정</button></th>
	    </tr>
	</table>
</form>
</body>
</html>