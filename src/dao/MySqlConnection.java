//public class MysqlConnection {
//
//	public static Connection getConnection() throws ClassNotFoundException,
//			SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/studentdb", "root", "");
//		return con;
//	}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/studentdb", "root", "");
		return con;
	}

}
