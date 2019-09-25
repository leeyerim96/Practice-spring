package springTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import util.MemberDAO;
import vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
// Spring ���� 
// => @Autowired Test -> 1) @Repository  , 2) ����ȭ�Ͽ� bean ��� Test
// => DAO ���� memberLogin �ÿ� �ش� �ڷḦ ����� �о� ������ Test		
	@Autowired // ����,����
	private MemberDAO dao ;
	@Test
	public void memberLoginTest() {
		MemberVO vo = new MemberVO() ;
		vo.setId("banana");
		vo.setPassword("12345");
		vo=dao.memberLogin(vo);
		if (vo!=null) {
				System.out.println(" Login ���� : id,password=>"
					+vo.getId()+" , "+vo.getPassword());
		}else 	System.out.println("** �α��� ���� **");
	} // memberLoginTest()
} // class
