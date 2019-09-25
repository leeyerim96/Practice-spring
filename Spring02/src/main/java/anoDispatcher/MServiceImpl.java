package anoDispatcher;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.MemberDAO;
import vo.MemberVO;

@Component("mm")
public class MServiceImpl implements MService {
	@Autowired 
	// ������ �����ϸ� �⺻ �����ڸ� ����ϹǷ� �ݵ�� �⺻ �����ڰ� �־�� ��
	MemberDAO dao ;
	
	public MServiceImpl() { }
	
	// Test1. �����ڸ� ���� ����
	//@Autowired
	public MServiceImpl(MemberDAO dao) {
		this.dao=dao;
	}
	
	// MemberList
	public ArrayList<MemberVO> selectList(){
		return dao.memberList();
	}
	// login
	public MemberVO loginCheck(MemberVO vo) {
		return dao.memberLogin(vo);
	} 
	// detail	
	public MemberVO selectOne(MemberVO vo) {
		return dao.mDetail(vo); 
	}

	@Override
	public int insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
} // class
