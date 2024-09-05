<%@page import="com.test.web.vo.MenuVO"%>
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
MenuVO menu = (MenuVO) request.getAttribute("menu");
%>
<form method="post" action="/menu/menu-delete">
<input type="hidden" name="miNum" value="<%=menu.getMiNum()%>">
<table border="1">
        <tr>
            <th>번호</th>
            <td><%=menu.getMiNum() %></td>
        </tr>
        <tr>
            <th>메뉴명</th>
            <td><%=menu.getMiName() %></td>
        </tr>
        <tr>
            <th>가격</th>
            <td><%=menu.getMiPrice() %></td>
        </tr>
        <tr>
            <th>메뉴 사진</th>
            <td><img src="<%=menu.getMiPath() %>"></td>
        </tr>
        <tr>
            <th colspan="2">
                <button type="button" onclick="location.href='/menu/menu-update?miNum=<%=menu.getMiNum()%>'">수정</button>
                <button>삭제</button>
            </th>
        </tr>
        
    </table>
</form>
<a href="/menu/menu-list">메뉴 전체보기</a>
</body>
</html>