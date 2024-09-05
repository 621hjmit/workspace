<%@page import="java.sql.*"%>
<%@page import="test.web.common.DBCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- user-insert-ok.jsp -->
<%
request.setCharacterEncoding("UTF-8");
String uiName = request.getParameter("uiName");
String uiId = request.getParameter("uiId");
String uiPwd = request.getParameter("uiPwd");
String uiGender = request.getParameter("uiGender");
String uiBirth = request.getParameter("uiBirth");
String[] uiHobbies = request.getParameterValues("uiHobby");
String uiDesc = request.getParameter("uiDesc");
String uiHobby = "";
for(int i=0; i<uiHobbies.length; i++){
    uiHobby += uiHobbies[i] + ",";  
};
uiHobby = uiHobby.substring(0,uiHobby.length()-1);
uiBirth = uiBirth.replace("-", "");
%>
Name : <%=uiName%><br>
ID : <%=uiId%><br>
Pwd : <%=uiPwd%><br>
Gender : <%=uiGender%><br>
Birth : <%=uiBirth%><br>
Hobby :<%=uiHobby%><br>
Desc : <%=uiDesc%>
<%
Connection con = DBCon.getCon();
String sql = "INSERT INTO USER_INFO\n"
        + "(UI_NAME, UI_ID, UI_PWD, UI_GENDER,\n"
        + "UI_BIRTH, UI_HOBBY, UI_DESC)\n"
        + "VALUES(\n"
        + "?,?,?,?,\n"
        + "?,?,?)";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, uiName);
ps.setString(2, uiId);
ps.setString(3, uiPwd);
ps.setString(4, uiGender);
ps.setString(5, uiBirth);
ps.setString(6, uiHobby);
ps.setString(7, uiDesc);
int result = ps.executeUpdate();
//int result = 1;
if(result==1){
%>
<script>
    alert('회원가입이 완료 되었습니다.');
    location.href='/user2/user-list.jsp';
</script>
<%
}else{
%>
<script>
    alert('회원가입이 실패하였습니다.');
    location.href='/user2/user-insert.jsp';
</script>
<%
}
ps.close();
con.close();
%>