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
		out.print("�̸��� "+recv.getName()+" ���̴� "+recv.getAge());
	%>
	<br/>
	<a href='index.jsp'>Ȩ</a>
</body>
</html>