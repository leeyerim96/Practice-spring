package jspTest;

import org.junit.Test;

import util.MemberDAO;
import vo.MemberVO;

public class MemberDAOTest {
	
	// DAO 에서 Login시에 정확하게 성공&실패를 구현 했는지 Test
	public void memberLoginTest() {
		MemberVO vo = new MemberVO();
		// test1. 성공
//		vo.setId("banana");
//		vo.setPassword("12345");
		// test2. 실패
		vo.setId("banana333");
		vo.setPassword("12345");
		MemberDAO dao = new MemberDAO() ;
		vo = dao.memberLogin(vo) ;
		if (vo!=null) {
			System.out.println(" Login 성공 : id,password=>"
							+vo.getId()+" , "+vo.getPassword());
		}else {
//			System.out.println(" Login 실패 : id,password=>"
//					+vo.getId()+" , "+vo.getPassword());
			// vo = null 상황에서 getId, getPassword 하려니 NullPointException 발생
			// => 불안정한 코드임 : red Line
			System.out.println("** Login 실패  **") ;
		}
	} // memberLoginTest()
	
	@Test
	public void memberJoinTest() {
		MemberVO vo = new MemberVO() ;
		// test1. 입력 성공
		// vo.setId("jUnitTest");
		// test2. 입력 실패
		vo.setId("banana");
		vo.setBirthd("1909-09-09");
		vo.setLev("C");
		vo.setName("제이제이");
		vo.setPassword("12345!");
		vo.setPay(12345);
		vo.setWeight(33.34);
		MemberDAO dao = new MemberDAO();
		int cnt=dao.mInsert(vo);
		if (cnt>0) System.out.println("** Join 성공 **");
		else System.out.println("** Join 실패 **");
	}
	
} // class
