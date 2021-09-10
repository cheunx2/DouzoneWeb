<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="Pack.User" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 페이지</title>
</head>
<body>
	<jsp:useBean id="recv" class="Pack.User" scope="page"/>
	<jsp:setProperty name="recv" property="uId" />
	<jsp:setProperty name="recv" property="infoCheck" />
	
	<form method=POST action="loginSQL.jsp">
		<table width="270" border="1" cellpadding="5">
			<tr>
				<td colspan="2" align="center">로그인</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
				<input required type="text" name="uId" placeholder="아이디" value = "<%=
				(recv.getuId() == null) ? "" : recv.getuId()
				 %>" >
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
				<input type="text" name="pass" placeholder="비밀번호" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style ="color:red">
					<%
						Boolean infoCheck = recv.getInfoCheck();
						String uid = recv.getuId();
						if(infoCheck){
							out.print("아이디 또는 비밀번호가 틀렸습니다.");
						}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='findid.jsp'">아이디 찾기</button>
	<button onclick="location.href='findpass.jsp'">비밀번호 찾기</button>
	<button onclick="location.href='Join.jsp'">회원가입</button>
</body>
</html>