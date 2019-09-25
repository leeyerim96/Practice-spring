package jspTest;

import org.junit.Test;

import util.MemberDAO;
import vo.MemberVO;

public class MemberDAOTest {
	
	// DAO ���� Login�ÿ� ��Ȯ�ϰ� ����&���и� ���� �ߴ��� Test
	public void memberLoginTest() {
		MemberVO vo = new MemberVO();
		// test1. ����
//		vo.setId("banana");
//		vo.setPassword("12345");
		// test2. ����
		vo.setId("banana333");
		vo.setPassword("12345");
		MemberDAO dao = new MemberDAO() ;
		vo = dao.memberLogin(vo) ;
		if (vo!=null) {
			System.out.println(" Login ���� : id,password=>"
							+vo.getId()+" , "+vo.getPassword());
		}else {
//			System.out.println(" Login ���� : id,password=>"
//					+vo.getId()+" , "+vo.getPassword());
			// vo = null ��Ȳ���� getId, getPassword �Ϸ��� NullPointException �߻�
			// => �Ҿ����� �ڵ��� : red Line
			System.out.println("** Login ����  **") ;
		}
	} // memberLoginTest()
	
	@Test
	public void memberJoinTest() {
		MemberVO vo = new MemberVO() ;
		// test1. �Է� ����
		// vo.setId("jUnitTest");
		// test2. �Է� ����
		vo.setId("banana");
		vo.setBirthd("1909-09-09");
		vo.setLev("C");
		vo.setName("��������");
		vo.setPassword("12345!");
		vo.setPay(12345);
		vo.setWeight(33.34);
		MemberDAO dao = new MemberDAO();
		int cnt=dao.mInsert(vo);
		if (cnt>0) System.out.println("** Join ���� **");
		else System.out.println("** Join ���� **");
	}
	
} // class
