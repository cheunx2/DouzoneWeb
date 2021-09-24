<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>메인 페이지</title>
</head>
<body>
	<form action="insertPerson">
		<table border = '1'>
			<tr>
				<td>이름</td>
				<td>
				<input type="text" name="name" value="test" >
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
				<input type="text" name="age" value="10">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="제출">
				</td>
			</tr>
		</table>
	</form>
	<a href ="selectPerson">목록 조회</a>
</body>