<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- /user/user-insert.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function validForm(){
    const uiName = document.querySelector("#uiName");
    if(uiName.value.trim().length<2){
        alert("이름은 1한글자 이상입니다.");
        uiName.value = '';
        uiName.focus();
        return false;
    }

    const uiId = document.querySelector("#uiId");
    if(uiId.value.trim().length<4){
        alert("아이디는 네글자 이상입니다.");
        uiName.value = '';
        uiName.focus();
        return false;
    }
    
    const uiPwd = document.querySelector("#uiPwd");
    if(uiPwd.value.trim().length<5){
        alert("비밀번호는 네글자 이상입니다.");
        uiName.value = '';
        uiName.focus();
        return false;
    }
    
    const uiGenders = document.querySelectorAll("input[name=uiGender]:checked");
    if(uiGenders.length<1){
    	alert("성별을 체크해주세요.");
    	document.querySelector("input[name=uiGender]").focus();
        return false;
    }
}
</script>
<form method="post" action="/user/user-insert" onsubmit="return validForm();">
    <p>
        <label for="uiName"  >이름 : </label>
        <input name="uiName" type="text" id="uiName">
    </p>
    <p>
        <label for="uiId"    >아이디 : </label>
        <input name="uiId" type="text" id="uiId">
    </p>
    <p>
        <label for="uiPwd"   >비밀번호 : </label>
        <input name="uiPwd" type="password" id="uiPwd">
    </p>
    <p>
        <label for="uiGender">성별 : </label>
        <input name="uiGender" type="radio" value="1" id="uiGenderMale">
        <label for="uiGenderMale">남성</label>
        <input name="uiGender" type="radio" value="2" id="uiGenderFemale">
        <label for="uiGenderFemale">여성</label>
    </p>
    <p>
        <label for="uiBirth" >생년월일 : </label>
        <input name="uiBirth" type="date" id="uiBirth">
    </p>
    <p>
        <label for="uiHobby" >취미 : </label>
        <input name="uiHobby" type="checkbox" value="자전거" id="bike">
        <label for="bike">자전거</label>
        <input name="uiHobby" type="checkbox" value="영화" id="movie">
        <label for="movie">영화</label>
        <input name="uiHobby" type="checkbox" value="드라이브" id="drive">
        <label for="drive">드라이브</label>
        <br>&emsp;&emsp;&ensp;
        <input name="uiHobby" type="checkbox" value="캠핑" id="camping">
        <label for="camping">캠핑</label>
        <input name="uiHobby" type="checkbox" value="웹서핑" id="websurfing">
        <label for="websurfing">웹서핑</label>
        <input name="uiHobby" type="checkbox" value="운동" id="workout">
        <label for="workout">운동</label>
    </p>
    <p>
        <label for="uiDesc"  >자기소개 : </label>
        <textarea name="uiDesc" id="uiDesc" rows="10" cols="80"  ></textarea>
    </p>
    <button>회원가입</button>
</form>
</body>
</html>