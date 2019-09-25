package springMtTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Test01_DataSource {
	// DataSource : ���� ���������� �̿��Ͽ� �������� ����, �ڵ� ���� Test
	@Autowired
	private DataSource ds ;
	@Test
	public void connectionTest() throws Exception {
		try {
			Connection cn = ds.getConnection();
			System.out.println("** DB ���� ���� , cn =>"+cn+"\n");
		} catch (Exception e) {
			System.out.println("** DB ���� ���� **");
			System.out.println("Exception :"+e.toString());
		}
	} // connectionTest()
	
	
	
	

}
