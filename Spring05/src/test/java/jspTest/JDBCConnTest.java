package jspTest;

import java.sql.DriverManager;

import org.junit.Test;

// JDBC Connection Test
// Oracle 10g
public class JDBCConnTest {
	@Test
	// ���� �׽�Ʈ �̹Ƿ� , �޼��� ����, non_static , void
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			DriverManager.getConnection(url,"system","oracle");
			System.out.println("** DB ���� ���� **");
		} catch (Exception e) {
			System.out.println("** DB ���� ���� **");
			System.out.println("Exception :"+e.toString());
		}
	} //getConnection() 
} //class
