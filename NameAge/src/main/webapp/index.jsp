<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="c">
<title>이름 나이</title>
</head>
<body>
	<form method=POST action="insert.jsp">
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
				<td colspan="2" align="center"><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
</body>
</html>