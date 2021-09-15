package Pack;

import java.sql.*;

public class UserDao {
	ConnectionMaker c = null;
	
	public UserDao() {
		this.c = new UserConnection();
	}
	
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String name = user.getName();
		String age = user.getAge();
		
		try {
			conn = c.connect();
			String sql = String.format(
					"insert into userinfo(uname, age) values('%s','%s');",
					name, age);

			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			conn.close();

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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}