package business;

import java.util.ArrayList;

import vo.MemberVO;

public interface MService {

	ArrayList<MemberVO> selectList();

	
	  MemberVO selectOne(MemberVO vo);
	  
	  MemberVO loginCheck(MemberVO vo);
	  
	  
	  int insert(MemberVO vo);
	  
	  int delete(MemberVO vo);
	  
	  int update(MemberVO vo);


}