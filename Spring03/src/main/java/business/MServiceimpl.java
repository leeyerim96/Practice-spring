package business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.MemberDAO;
import vo.MemberVO;

// Service Ŭ������ ����
// => Controller �� ��û�� ���� DAO �� �ش� �޼��带 ����
// => �׷��Ƿ� DAO�� ��� ����� ó���ϴ� �޼��� ����
// => Shift+art+T : interface �ڵ����� ����޴�

@Service("member")
public class MServiceimpl implements MService {
	@Autowired //���Ը� ���ִ� �� @Repository ����� ���� 
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
