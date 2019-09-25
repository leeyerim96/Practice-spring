package anoDispatcher;

import java.util.ArrayList;
import vo.MemberVO;

public interface MService {
// MemberList
	ArrayList<MemberVO> selectList();
// login
	MemberVO loginCheck(MemberVO vo);
// detail	
	MemberVO selectOne(MemberVO vo);
	int insert(MemberVO vo);
} // MService
