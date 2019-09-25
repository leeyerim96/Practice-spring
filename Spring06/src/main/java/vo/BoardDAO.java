package vo;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	// EntityManager 객체 주입시 사용하는 어노테이션
	@PersistenceContext
	private EntityManager dao;
	
	public ArrayList<BoardVO> selectList(){
		return (ArrayList)dao.createQuery("from BoardVO b order by b.root desc, b.step asc").getResultList();
	}
	
	public BoardVO selectOne(BoardVO vo) {
		return dao.find(BoardVO.class, vo.getSeq());
	}
}
