<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import ="Pack01.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="Pack01.User" scope="page"/>
	<jsp:setProperty name="user" property="*" />
	<h1>
		<center>����� ����</center>
	</h1>
	<form action="voting">

		<table class="sty" border='3' width="400" height="200" align="center">
			<tr>
				<td colspan='3'><label><input type="radio" name="num"
						value='1'> 1. ȫ�浿 </label><br /> <label><input
						type="radio" name="num" value='2'> 2. ������ </label><br /> <label><input
						type="radio" name="num" value='3'> 3. �̼��� </label></td>
				<br />
			</tr>
			<tr align='center'>
				<td colspan='3'><input type="submit" value="��ǥ"> <input
					type="submit" value="���" onClick="location.href='redirect:index.jsp'"></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" value="<%= user.getUname()%>" name="uname">
					<input type="hidden" value="<%= user.getUtel()%>" name="utel">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>