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
<title>ȸ�� ���� ����</title>
</head>
<body>
<%
    String ID = "root";                         // MySQL ���̵�
    String PWD= "1234";                         // MySQL ��й�ȣ
    String PORTNO = "3306";                     // MySQL ��Ʈ ��ȣ
    String DBNAME = "db01";                     // ������ MySQL DB �̸�
 
    String Query = "jdbc:mysql://localhost:" + PORTNO + "/" + DBNAME + "?";                                             
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(Query, ID, PWD);  
 
    if (conn != null) {
    }
    else {
        out.println("WebDB �����ͺ��̽��� ������ �� �����ϴ�.<br>");
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