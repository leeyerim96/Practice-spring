package business;

import java.util.ArrayList;

import vo.BoardVO;
import vo.PageVO;


public interface BService {

	
	ArrayList<BoardVO> selectList();
	
	PageVO  pageList(PageVO pvo); 
	
	BoardVO selectOne(BoardVO vo);

	int insert(BoardVO vo);

	int update(BoardVO vo);

	int delete(BoardVO vo);

	int countUp(BoardVO vo); 
	
	int rinsert(BoardVO vo);
}