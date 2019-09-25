package business;

import java.util.ArrayList;

import vo.BoardVO;
import vo.PageVO;

public interface BService {
	ArrayList<BoardVO> idselectList(BoardVO vo); // AjaxTest
	int totalRowCount(); //  totalRowCount
	ArrayList<BoardVO> pageList(PageVO pvo); // pageList
	ArrayList<BoardVO> selectList(); // selectList
	BoardVO selectOne(BoardVO vo); // selectOne
	int insert(BoardVO vo); // insert
	int update(BoardVO vo); // update
	int delete(BoardVO vo); // delete
	int countUp(BoardVO vo); // countUp
	int rinsert(BoardVO vo); // reply insert
} // interface