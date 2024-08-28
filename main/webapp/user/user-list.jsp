<%@page import="java.sql.*"%>
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
String id = "root";
String pwd = "r1r2r3";
String url = "jdbc:ariadb://localhost:3307/ezen";
String driverName = "org.mariadb.jdbc.Driver";

Connection con= DriverManager.getConnection(url,id,pwd);
Statement stmt = con.createStatement();
String sql = "SELECT * FROM USER_INFO";
ResultSet rs = stmt.executeQuery(sql);

while(rs.next()){
    out.println(rs.getString("UI_NUM") + ",");
    out.println(rs.getString("UI_NAME") + ",");
    out.println(rs.getString("UI_ID") + ",");
    out.println(rs.getString("CREDAT") + "<BR>");
}
%>
</body>
</html>