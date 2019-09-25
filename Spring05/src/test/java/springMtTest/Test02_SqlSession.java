package springMtTest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Test02_SqlSession {
	@Autowired
	private SqlSessionFactory sqlFactory ;
	
	// @Before(value="testSession()")
	// import org.aspectj.lang.annotation.Before;
	@Test
	public void testFactory() {
		System.out.println("**  SqlSessionFactory 자동주입 Test sqlFactory => \n"+sqlFactory+"\n");
	}
	@Test
	public void testSession() {
		// 실제 DB 연결, Mapper 와 ServiceImpl 의 연결 을 처리하는  SqlSession 객체 생성 Test	
		try {
			SqlSession session = sqlFactory.openSession() ;
			System.out.println("**  SqlSession 주입 Test SqlSession => \n"+session+"\n");
		} catch (Exception e) {
			System.out.println("**  SqlSession 주입Exception => "+e.toString());
		} // catch
	} // testSession
	
} // class
