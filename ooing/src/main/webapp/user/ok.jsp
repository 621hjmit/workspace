<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uId = request.getParameter("uId");
String uName = request.getParameter("uName");
String uPwd = request.getParameter("uPwd");
%>
<%="이름 : " + uName%><br>
<%="아이디 : " + uId%><br>
<%="비번 : " + uPwd%><br>
ok. to insert.