package Pack01;

import java.sql.*;

import org.springframework.ui.Model;

public class Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	Model model;

	public String userCheck(String uname, String utel) {
		String match = "0";
		try {
			connect();
			String sql = String.format(
					"select count(*) as cnt from userinfo where uname ='%s' and utel='%s' and vote=false;",
					uname, utel);
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			if (result.next()) {
				match = result.getString("cnt");
			}
			System.out.println(match);
			close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
	}
	
	public void vote(String uname, String utel, Integer num) {
		try {
			connect();
			String sql = String.format(
					"update userinfo set vote = true where uname ='%s' and utel='%s';",
					uname, utel);
			String sql1 = String.format(
					"insert into election values(%d);",
					num);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db01";
			conn = DriverManager.getConnection(url, "root", "1234");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	void close() {
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
}