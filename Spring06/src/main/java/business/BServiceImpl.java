package business;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.BoardDAO;
import vo.BoardVO;


@Service
public class BServiceImpl implements BService {
	@Autowired
	private BoardDAO dao ;
	
	
	@Override
	public ArrayList<BoardVO> selectList() {
		return dao.selectList();
	}
	
	@Override
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOne(vo) ;
	} // selectOne


	
	
} // class

