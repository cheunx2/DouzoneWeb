<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Pack.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="recv" class="Pack.User" scope="page"/>
	<jsp:setProperty name="recv" property="*"/>
	
	<% 	
		out.print("이름은 "+recv.getName()+" 나이는 "+recv.getAge());
	%>
	<br/>
	<a href='index.jsp'>홈</a>
</body>
</html>