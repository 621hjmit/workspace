<%@ page import="lotto.common.DBCon"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
        <th>번호</th>
        <th>TIMESTAMP</th>
        <th>1</th>
        <th>2</th>
        <th>3</th>
        <th>4</th>
        <th>5</th>
        <th>6</th>
        <th>B</th>
    </tr>
<%
Connection con = DBCon.getCon();
String sql = "SELECT * FROM LOTTO_INFO";
PreparedStatement ps = con.prepareStatement(sql); 
ResultSet rs = ps.executeQuery();
while(rs.next()){
    out.println("<tr>");
    out.println("<td>"+rs.getString("LT_NUM")+"</td>");
    out.println("<td>"+rs.getString("LT_TIME")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_1")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_2")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_3")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_4")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_5")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_6")+"</td>");
    out.println("<td>"+rs.getString("LT_NUMBER_B")+"</td>");
    out.println("</tr>");
}
%>
</table>
<button onclick="insertLotto()">등록</button>
<script>
function insertLotto(){
    location.href="/lotto/lotto-insert.jsp";
};
</script>
</body>
</html>