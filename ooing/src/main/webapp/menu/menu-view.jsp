   <!-- menu-view.jsp -->
<%@ page import="test.web.common.DBCon" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String miNum = request.getParameter("miNum");
Connection con = DBCon.getCon();
String sql  = "SELECT MI_NUM, MI_NAME, MI_PRICE, MI_DESC ";
       sql += "FROM MENU_INFO WHERE MI_NUM=?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, miNum);
ResultSet rs = ps.executeQuery();
if(rs.next()){
%>
    <form action="/menu/menu-update-ok.jsp" method="GET" id="frm">
    <p>번호 : <% out.println(miNum); %></p>
    <p>메뉴 : <input type="text" name="miName"  value="<%=rs.getString("MI_NAME")%>"></p>
    <p>가격 : <input type="text" name="miPrice" value="<%=rs.getString("MI_PRICE")%>"></p>
    <p>설명 : <textarea name="miDesc"><%=rs.getString("MI_DESC")%></textarea></p>
    <input type="hidden" name="miNum" value="<%=rs.getString("MI_NUM")%>">
    <p><button>메뉴 수정</button></p>
    <p><button type="button" onclick="changeAction(1)">메뉴 삭제</button></p>
    </form>
    
<script>
function changeAction(){
    const frm = document.querySelector('#frm');
    frm.action = '/menu/menu-delete-ok.jsp';
    frm.submit();
}
</script>
<%
}else{
%>
    <p>조회하신 메뉴가 이미 삭제되었습니다.</p>
<%}%>
    <a href="/menu/menu-list.jsp">돌아가기</a>
</body>
</html>