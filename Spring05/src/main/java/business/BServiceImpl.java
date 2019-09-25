package business;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.BoardVO;
import vo.PageVO;

@Service
public class BServiceImpl implements BService {
	@Autowired
	private SqlSession dao ;
	private static final String NS ="green.mapper.BoardMapper." ;
	
	@Override
	public int totalRowCount() {      // 게시판 글 갯수 ?
		return dao.selectOne(NS+"totalrowCount");
	}
	
	public ArrayList<BoardVO> pageList(PageVO pvo) {
		return (ArrayList)dao.selectList(NS+"pageList", pvo);
	} 
	
	@Override
	public ArrayList<BoardVO> idselectList(BoardVO vo) {
		return (ArrayList)dao.selectList(NS+"idselectList",vo);
	} // selectList
	
	@Override
	public ArrayList<BoardVO> selectList() {
		return (ArrayList)dao.selectList(NS+"selectList");
	} // selectList
	
	@Override
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(NS+"selectDetail",vo) ;
	} // selectOne
	
	@Override
	public int insert(BoardVO vo) {
		return dao.insert(NS+"insertBoard",vo) ;
	} // insert
	
	@Override
	public int update(BoardVO vo) {
		return dao.update(NS+"updateBoard",vo) ;
	} // update
	
	@Override
	public int delete(BoardVO vo) {
		return dao.delete(NS+"deleteBoard",vo) ;
	} // delete
	
	@Override
	public int countUp(BoardVO vo) {
		return dao.update(NS+"countUp",vo) ;    
	} // countUp
	
	@Override
	public int rinsert(BoardVO vo) {
		System.out.println("** rinsert StepUp count =>"+dao.update(NS+"stepUpdate",vo));
		return dao.insert(NS+"rinsertBoard",vo) ;
	} // rinsert
	
} // class

