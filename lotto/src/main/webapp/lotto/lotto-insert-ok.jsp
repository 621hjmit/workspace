<%@page import="lotto.common.DBCon"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String miName = request.getParameter("miName");
String miPrice = request.getParameter("miPrice");
String miDesc = request.getParameter("miDesc");

Connection con = DBCon.getCon();

String sql = "INSERT INTO MENU_INFO(MI_NAME, MI_PRICE, MI_DESC) VALUES(? , ? , ?)";

PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, miName);
ps.setString(2, miPrice);
ps.setString(3, miDesc);

int result = ps.executeUpdate();

if(result == 1){
%>
<script>
    alert('저장성공');
    location.href="/menu/menu-list.jsp";
</script>
<%
}
%>