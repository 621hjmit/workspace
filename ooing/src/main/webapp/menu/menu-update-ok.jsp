<%@page import="java.sql.*"%>
<%@page import="test.web.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String miName = request.getParameter("miName");
String miPrice = request.getParameter("miPrice");
String miDesc = request.getParameter("miDesc");

Connection con = DBCon.getCon();
String sql = "UPDATE MENU_INFO SET MI_NAME=?, MI_PRICE=?, MI_DESC=?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1,miName);
ps.setString(2,miPrice);
ps.setString(3,miDesc);
int result = ps.executeUpdate();
if(result >0){
%>
<script>
    alert('정보 수정이 완료 되었습니다.');
    location.href='/menu/menu-list.jsp';
</script>
<%
}else{
%>
<script>
    alert('정보 수정이 실패하였습니다.');
    location.href='/menu/menu-list.jsp';
</script>
<%
}
%>