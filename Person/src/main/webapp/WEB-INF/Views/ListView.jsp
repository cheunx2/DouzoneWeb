<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>이름</th>
			<th>나이</th>	
		</tr>
		<c:forEach var="i" items="${mmm}">	
		<tr>
			<td>${i.name}</td>
			<td>${i.age}</td>					
		</tr>
		</c:forEach>	
	</table>
	<a href = "index.jsp">첫화면으로</a>
</body>
</html>