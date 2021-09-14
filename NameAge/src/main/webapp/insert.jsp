<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8");
   response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="recv" class="Pack.User" scope="page"/>
	<jsp:setProperty name="recv" property="*" />

	<%
	String name = recv.getName();
	String age = recv.getAge();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
    
	try {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://118.38.27.198:7777/db01";
		conn = DriverManager.getConnection(url, "postgres", "postgres");
		// ¿¬°á ³¡

		String sql = "insert into userinfo(uname, age) values(?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, age);
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (conn != null && !conn.isClosed()) {
		conn.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
		pstmt.close();
			}
			if (result != null && !result.isClosed()) {
		result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//response.sendRedirect("Success.jsp?name="+ name+"&age="+age);
	%>
</body>
</html>