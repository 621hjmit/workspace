<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  menu-insert.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Integer[] lottomNums = new Integer[7];
Random rand = new Random();
int tempNum = 0;
String str = "";
for (int i = 0; i < 7; i++) {
    tempNum = rand.nextInt(45) + 1;
    for (int a = 0; a < i; a++) {
        while (true) {
            if (tempNum == lottomNums[a]) {
                tempNum = rand.nextInt(45) + 1;
            } else {
                break;
            }
        }
    }
    lottomNums[i] = tempNum;
}
for (int i = 0; i < 7; i++) {
   	str += lottomNums[i]+ " ";
}
%>
    <p><%=str %></p>
	<form action="/lotto/lotto-insert-ok.jsp" method="POST">
		<% for(int i= 0; i<7;i++){
		    out.println("<input hidden type='text' name='l" + i + "' value='"+ lottomNums[i] +"'>");
		} %>
		    
	    <button>로또등록</button>
	</form>
</body>
</html>