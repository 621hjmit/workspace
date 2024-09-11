<%@page import="com.remind.test.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<%
UserVO user = (UserVO)request.getAttribute("user");
%>
<form method="POST" action="/user/user-update" id="frm">
	<input type="hidden" name="uiNum" value="<%=user.getUiNum()%>">
	<table border="1">
		<tr>
			<th>번호</th>
			<td><%=user.getUiNum() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="uiName" value="<%=user.getUiName()%>"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="uiId" value="<%=user.getUiId()%>"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" id="pwd1" value="">
				<input type="password" id="pwd2" name="uiPwd" value="">
				<br>
				<p id="message"></p>
			</td>
		</tr>
		<tr>
			<th colspan="2"><button>수정</button> <button type="button" onclick="changeAction(this.form)">삭제</button></th>
		</tr>
	</table>
</form>
<script>
	function changeAction(frm){
		frm.action='/user/user-delete';
		frm.submit();
	}
    $(function(){
    	$("#pwd2").focusout(function(){
            var pwd1=$("#pwd1").val();
            var pwd2=$("#pwd2").val();
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                	$("#message").empty();
                	$("#message").append("일치합니다.");                	
                }else{
                	$("#message").empty();
                	$("#message").append("다시입력해주.");
                }    
            }
        });
    });
</script>​
</body>
</html>