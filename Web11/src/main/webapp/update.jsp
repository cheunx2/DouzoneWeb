<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ����</title>
</head>
<body>
	<fieldset>
		<legend>ȸ������</legend>
			<FORM METHOD = POST action = "list.jsp">
			<INPUT TYPE="text" NAME="name" VALUE="apple"><p/>
			<INPUT TYPE="submit" VALUE="����">
			</FORM>
	</fieldset> 
	<table>
		<tr>
			<td>���̵�</td>
			<td>��й�ȣ</td>
		</tr>
		<tr>
			<td><%= request.getParameter("uid")%></td>
			<td><%= request.getParameter("pass")%></td>
		</tr>
		<tr>
			<td><INPUT TYPE="text" NAME="uid"></td>
			<td><INPUT TYPE="text" NAME="pass"></td>
		</tr>
	</table>
	
</body>
</html>