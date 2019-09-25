package memberDI;

import java.util.ArrayList;

import vo.MemberVO;

public interface MService {
// MemberList
   ArrayList<MemberVO> selectList();
// login
   MemberVO loginCheck(MemberVO vo);
// detail
   MemberVO selectOne(MemberVO vo);
} //MService