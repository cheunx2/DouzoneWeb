<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="c">
<title>�̸� ����</title>
</head>
<body>
	<form method=POST action="insert.jsp">
		<table border = '1'>
			<tr>
				<td>�̸�</td>
				<td>
				<input type="text" name="name" value="test" >
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
				<input type="text" name="age" value="10">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="����"></td>
			</tr>
		</table>
	</form>
</body>
</html>