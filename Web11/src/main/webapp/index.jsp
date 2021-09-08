 <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="a.jsp?fullName=tiger">전송1</a>
	
	<% String s1 = "Lion"; %>
	<a href="b.jsp?fullName=<%=s1%>">전송2</a>
	
	<a href="c.jsp?fullName=tiger&age=1000">전송3</a>
	
	<% 
		String s2 = "Happy"; 
		int num = 999;
	%>
	<a href="d.jsp?fullName=<%=s2%>&age=<%=num%>">전송4</a>
	
	<a href="http://www.daum.net">다음</a>
	
	<%
		String name ="Haapy";
		int age = 333;
	%>
	
	<form action="e.jsp">
		<input type="text" name="tel" value=<%=name%>>
		<input type="hidden" name="age" value=<%=age%>>
		<input type="submit" value="다음단계">
	</form>
	
	<a href="index.jsp">새로고침</a>
	
</body>
</html>