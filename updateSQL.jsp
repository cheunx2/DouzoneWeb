<%@ page import = "java.sql.Connection" %>
    <%@ page import ="java.sql.DriverManager" %>
    <%@ page import ="java.sql.PreparedStatement" %>
    <%@ page import ="java.sql.ResultSet" %>
    <%@ page import ="java.sql.SQLException" %>
    <%@ page import ="java.sql.Statement" %>
    
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 변경</title>
</head>
<body>
<%
    String ID = "root";                         // MySQL 아이디
    String PWD= "1234";                         // MySQL 비밀번호
    String PORTNO = "3306";                     // MySQL 포트 번호
    String DBNAME = "db01";                     // 연결할 MySQL DB 이름
 
    String Query = "jdbc:mysql://localhost:" + PORTNO + "/" + DBNAME + "?";                                             
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(Query, ID, PWD);  
 
    if (conn != null) {
    }
    else {
        out.println("WebDB 데이터베이스로 연결할 수 없습니다.<br>");
    }
    try{
    
    String uid = request.getParameter("uid");
    String changeId = request.getParameter("changeId");
    String changePass = request.getParameter("changePass");
    
    out.println(uid);
    out.println(changeId);
    out.println(changePass);
    
    String sql = "UPDATE users SET uid = ?, pass = ? WHERE uid = ?";
    
    PreparedStatement pstmt = conn.prepareStatement(sql);
    
    pstmt.setString(1, changeId);
    pstmt.setString(2, changePass);
    pstmt.setString(3, uid);
	
    pstmt.executeUpdate();
    pstmt.close();
    	
    }catch(SQLException e){
    	out.print(e);
    }
    
	conn.close(); 
	response.sendRedirect("list.jsp"); 
	%>
	
</body>
</html>