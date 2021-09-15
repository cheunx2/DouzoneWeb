<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="Pack.User"%>
<%@ page import="Pack.UserDao"%>
<% request.setCharacterEncoding("UTF-8");%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="recv" class="Pack.User" scope="page"/>
	<jsp:useBean id= "userDao" class="Pack.UserDao" scope="page"/>
	<jsp:setProperty name="recv" property="*" />

	<%
	userDao.addUser(recv);
	
	response.sendRedirect("Success.jsp?name="+ recv.getName()+"&age="+recv.getAge());
	%>
</body>
</html>