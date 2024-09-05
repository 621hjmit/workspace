<%@page import="test.web.common.DBCon"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--  menu-delete-ok.jsp  -->
    
<%
String miNum = request.getParameter("miNum");
Connection con = DBCon.getCon();
Statement stmt = con.createStatement();
String sql = "DELETE FROM MENU_INFO WHERE MI_NUM=" + miNum;

int result = stmt.executeUpdate(sql);
if(result==1){
%>
<script>
    alert('삭제 완료');
    location.href='/menu/menu-list.jsp';
</script>
<%
}else{
%>
<script>
    alert('이미 삭제된 메뉴입니다.');
    location.href='/menu/menu-list.jsp';
</script>
<%
}
%>