package jspTest;

import java.sql.DriverManager;

import org.junit.Test;

// JDBC Connection Test
// Oracle 10g
public class JDBCConnTest {
	@Test
	// 단위 테스트 이므로 , 메서드 단위, non_static , void
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			DriverManager.getConnection(url,"system","oracle");
			System.out.println("** DB 연결 성공 **");
		} catch (Exception e) {
			System.out.println("** DB 연결 실패 **");
			System.out.println("Exception :"+e.toString());
		}
	} //getConnection() 
} //class
