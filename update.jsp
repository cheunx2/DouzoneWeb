<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ����</title>
</head>
<body>
	<table border="1" cellpadding="5" align=center>
		<tr>
			<td>���̵�</td>
			<td>��й�ȣ</td>
		</tr>
		<tr>
			<td><%= request.getParameter("uid")--%></td>
			<td><%= request.getParameter("pass")--%></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="updateSQL.jsp">
					<input type="hidden" name="uid" value=<%=uid%>> <input
						type="text" name="changeId"> <input type="text"
						name="changePass"> <input type="submit" value="����">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>