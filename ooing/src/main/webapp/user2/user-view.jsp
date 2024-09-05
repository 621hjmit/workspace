<%@page import="test.web.common.DBCon"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- user-view.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

<%
String uiNum = request.getParameter("uiNum");
Connection con = DBCon.getCon();
String sql = "SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD, UI_GENDER, STR_TO_DATE(UI_BIRTH,'%Y%m%D') AS UI_BIRTH, UI_HOBBY,UI_DESC "
+"FROM user_info WHERE UI_NUM= ? ";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1,uiNum);
ResultSet rs = ps.executeQuery();
//21년 개발 14년 가르침.
if(rs.next()){
%>
<form method="post" action="/user2/user-update-ok.jsp" id="frm">
    <input  name="uiNum" type="hidden" value="<%=rs.getString("UI_NUM")%>">
    <p>
        <label for="uiName"  >이름 : </label>
        <input name="uiName" type="text" id="uiName" value="<%=rs.getString("UI_NAME")%>">
    </p>
    <p>
        <label for="uiId"    >아이디 : </label>
        <input name="uiId" type="text" id="uiId" value="<%=rs.getString("UI_ID")%>">
    </p>
    <p>
        <label for="uiPwd"   >비밀번호 : </label>
        <input name="uiPwd" type="password" id="uiPwd">
    </p>
    <p>
        <label for="uiGender" data-gender="<%=rs.getString("UI_GENDER")%>" id="gender">성별 : </label>
        <input name="uiGender" type="radio" value="1" id="uiGenderMale" <%= rs.getString("UI_GENDER").contains("1")?"checked":"" %>>
        <label for="uiGenderMale">남성</label>
        <input name="uiGender" type="radio" value="2" id="uiGenderFemale" <%= rs.getString("UI_GENDER").contains("2")?"checked":"" %>>
        <label for="uiGenderFemale">여성</label>
    </p>
    <p>
        <label for="uiBirth" >생년월일 : </label>
        <input name="uiBirth" type="date" id="uiBirth" value="<%=rs.getString("UI_BIRTH")%>">
    </p>
    <p>
        <label for="uiHobby" data-hobby="<%=rs.getString("UI_HOBBY")%>" id="hobby">취미 : </label>
        <input name="uiHobby" type="checkbox" value="자전거" id="bike" <%= rs.getString("UI_HOBBY").contains("자전거")?"checked":"" %>>
        <label for="bike">자전거</label>
        <input name="uiHobby" type="checkbox" value="영화" id="movie" <%= rs.getString("UI_HOBBY").contains("영화")?"checked":"" %>>
        <label for="movie">영화</label>
        <input name="uiHobby" type="checkbox" value="드라이브" id="drive" <%= rs.getString("UI_HOBBY").contains("드라이브")?"checked":"" %>>
        <label for="drive">드라이브</label>
        <br>&emsp;&emsp;&ensp;
        <input name="uiHobby" type="checkbox" value="캠핑" id="camping" <%= rs.getString("UI_HOBBY").contains("캠핑")?"checked":"" %>>
        <label for="camping">캠핑</label>
        <input name="uiHobby" type="checkbox" value="웹서핑" id="websurfing" <%= rs.getString("UI_HOBBY").contains("웹서핑")?"checked":"" %>>
        <label for="websurfing">웹서핑</label>
        <input name="uiHobby" type="checkbox" value="운동" id="workout" <%= rs.getString("UI_HOBBY").contains("운동")?"checked":"" %>>
        <label for="workout">운동</label>
    </p>
    <p>
        <label for="uiDesc"  >자기소개 : </label>
        <textarea name="uiDesc" id="uiDesc" ><%=rs.getString("UI_DESC")%></textarea>
    </p>
    <button>정보수정</button>
</form>  
<%
}else{ 
%>
조회하신 유저가 이미 탈퇴되었습니다.<br>
<a href="/user2/user-list.jsp">돌아가기</a>
<%
}
%>


</body>
</html>