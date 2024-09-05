<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- /board/board-insert.jsp -->
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
<form method="post" action="/board/board-insert" onsubmit="return validForm();">
    <p>
        <label for="biTitle"  >제목 : </label>
        <input name="biTitle" type="text" id="biTitle">
    </p>
    <p>
        <label for="biAuthor">작성자 : </label>
        <input name="biAuthor" type="text" id="biAuthor">
    </p>
    <p>
        <label for="biBody"  >본문 : </label>
        <textarea name="biBody" type="text" id="biBody" cols="40" rows="10"></textarea>
    </p>
    <button>발행</button>
</form>
</body>
</html>