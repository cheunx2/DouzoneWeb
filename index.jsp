<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="Pack.User" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ������</title>
</head>
<body>
	<jsp:useBean id="recv" class="Pack.User" scope="page"/>
	<jsp:setProperty name="recv" property="uId" />
	<jsp:setProperty name="recv" property="infoCheck" />
	
	<form method=POST action="loginSQL.jsp">
		<table width="270" border="1" cellpadding="5">
			<tr>
				<td colspan="2" align="center">�α���</td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td>
				<input required type="text" name="uId" placeholder="���̵�" value = "<%=
				(recv.getuId() == null) ? "" : recv.getuId()
				 %>" >
				</td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td>
				<input type="text" name="pass" placeholder="��й�ȣ" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style ="color:red">
					<%
						Boolean infoCheck = recv.getInfoCheck();
						String uid = recv.getuId();
						if(infoCheck){
							out.print("���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
						}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="�α���"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='findid.jsp'">���̵� ã��</button>
	<button onclick="location.href='findpass.jsp'">��й�ȣ ã��</button>
	<button onclick="location.href='Join.jsp'">ȸ������</button>
</body>
</html>