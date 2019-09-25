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
// Spring 으로 
// => @Autowired Test -> 1) @Repository  , 2) 설정화일에 bean 등록 Test
// => DAO 에서 memberLogin 시에 해당 자료를 제대로 읽어 오는지 Test		
	@Autowired // 성공,실패
	private MemberDAO dao ;
	@Test
	public void memberLoginTest() {
		MemberVO vo = new MemberVO() ;
		vo.setId("banana");
		vo.setPassword("12345");
		vo=dao.memberLogin(vo);
		if (vo!=null) {
				System.out.println(" Login 성공 : id,password=>"
					+vo.getId()+" , "+vo.getPassword());
		}else 	System.out.println("** 로그인 실패 **");
	} // memberLoginTest()
} // class
