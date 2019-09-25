package util;

import java.sql.Connection;
import java.sql.DriverManager;

// DB connection 담당
public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			System.out.println("DB Connection 성공 ~~~~");
			return DriverManager.getConnection(url,"system","oracle");
		} catch (Exception e) {
			System.out.println("DB Connection 실패 =>"+e.toString());
			return null ;
		}
	} // getConnection()
} // class
