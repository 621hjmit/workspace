<%@page import="test.web.common.DBCon"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--  user-delete-ok.jsp  -->
    
<%
String uiNum = request.getParameter("uiNum");
String sql = "DELETE FROM USER_INFO WHERE UI_NUM=?";
Connection con = DBCon.getCon();
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1,uiNum);
int result = ps.executeUpdate();
if(result==1){
%>
<script>
    alert('삭제 완료');
    location.href='/user2/user-list.jsp';
</script>
<%
}else{
%>
<script>
    alert('이미 삭제된 유저입니다.<%=uiNum%>');
    location.href='/user2/user-list.jsp';
</script>
<%
}
%>