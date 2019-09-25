package business;

import java.util.ArrayList;

import vo.BoardVO;

public interface BService {


	ArrayList<BoardVO> selectList(); // selectList
	BoardVO selectOne(BoardVO vo); // selectOne
	
} // interface