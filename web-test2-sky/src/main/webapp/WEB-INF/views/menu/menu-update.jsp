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
<%MenuVO menu = (MenuVO) request.getAttribute("menu"); %>
<form method="post" action="/menu/menu-update" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <th>번호</th>
            <td>
                <%=menu.getMiNum() %>
                <input type="hidden" id="miNum" name="miNum" value="<%=menu.getMiNum() %>">
            </td>
       </tr>
       <tr>
           <th>메뉴명</th>
           <td><input type="text" id="miName" name="miName" value="<%=menu.getMiName() %>"></td>
       </tr>
       <tr>
           <th>가격</th>
           <td><input type="number" id="miPrice" name="miPrice" value="<%=menu.getMiPrice() %>"></td>
        </tr>
        <tr>
            <th>메뉴 사진</th>
            <td><input type="file" id="miPath" name="miPath"></td>
        </tr>
        <tr>
            <th colspan="2"><button>수정</button></th>
        </tr>
    </table>
</form>
</body>
</html>