<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 수정</title>
</head>
<body>
	<fieldset>
		<legend>회원가입</legend>
			<FORM METHOD = POST action = "list.jsp">
			<INPUT TYPE="text" NAME="name" VALUE="apple"><p/>
			<INPUT TYPE="submit" VALUE="전송">
			</FORM>
	</fieldset> 
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
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