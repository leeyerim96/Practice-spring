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
			System.out.println("***** Login ���� ...ID : " + vo.getId());
			System.out.println("***** Login ���� ...PW : " + vo.getPassword()); 
		}else 
			System.out.println("***** Login ���� ..."); 
	} // loginTest
	@Test
	public void joinTest() {
		MemberVO vo = new MemberVO() ;
		vo.setId("mybatis333");
		vo.setPassword("password");
		vo.setName("����Ʈ");
		vo.setLev("A");
		vo.setBirthd("1999-09-09");
		vo.setPay(100);
		vo.setWeight(23.45);
		vo.setUploadfile("uploadfile");
		int cnt = sqlsession.insert(NS+"insertMember",vo) ;
		if (cnt>0) 
			 System.out.println("***** join ���� *****");
		else System.out.println("***** join ���� *****");
		
	} // joinTest
} // class
