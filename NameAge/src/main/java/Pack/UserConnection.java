package Pack;

import java.sql.*;

interface ConnectionMaker{
	Connection connect();
}

public class UserConnection implements ConnectionMaker {
	@Override
	public Connection connect() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://118.38.27.198:7777/db01";
			conn = DriverManager.getConnection(url, "gang", "1234");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}