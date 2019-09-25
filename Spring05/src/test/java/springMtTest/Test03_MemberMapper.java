package springMtTest;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class Test03_MemberMapper {
	@Autowired
	private SqlSession sqlsession ;
	
	private static final String NS="green.mapper.MemberMapper." ;
	//@Test
	public void loginTest() {
		MemberVO vo = new MemberVO() ;
		vo.setId("banana");
		vo.setPassword("123456");
		
		vo = sqlsession.selectOne(NS+"loginMember", vo) ;
		// green.memberMapper loginMember
		if (vo!=null) {
			System.out.println("***** Login 성공 ...ID : " + vo.getId());
			System.out.println("***** Login 성공 ...PW : " + vo.getPassword()); 
		}else 
			System.out.println("***** Login 실패 ..."); 
	} // loginTest
	@Test
	public void joinTest() {
		MemberVO vo = new MemberVO() ;
		vo.setId("mybatis333");
		vo.setPassword("password");
		vo.setName("유니트");
		vo.setLev("A");
		vo.setBirthd("1999-09-09");
		vo.setPay(100);
		vo.setWeight(23.45);
		vo.setUploadfile("uploadfile");
		int cnt = sqlsession.insert(NS+"insertMember",vo) ;
		if (cnt>0) 
			 System.out.println("***** join 성공 *****");
		else System.out.println("***** join 실패 *****");
		
	} // joinTest
} // class
