package business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.MemberDAO;
import vo.MemberVO;

// Service 클래스의 역할
// => Controller 의 요청에 따라 DAO 의 해당 메서드를 실행
// => 그러므로 DAO의 모든 기능을 처리하는 메서드 구현
// => Shift+art+T : interface 자동생성 단축메뉴

@Service("member")
public class MServiceimpl implements MService {
	@Autowired //주입만 해주는 것 @Repository 해줬기 때문 
	private MemberDAO dao;
	
	@Override
	public ArrayList<MemberVO> selectList() {
		return dao.memberList();
	}
	
	@Override
	public MemberVO selectOne(MemberVO vo) {
		return dao.mDetail(vo);
	}
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.memberLogin(vo);
	}
	
	@Override
	public int insert(MemberVO vo) {
		return dao.mInsert(vo);
	}
	
	@Override
	public int delete(MemberVO vo) {
		return dao.mDelete(vo);
	}
	
	@Override
	public int update(MemberVO vo) {
	      return dao.mUpdate(vo);
	   }


	

}
