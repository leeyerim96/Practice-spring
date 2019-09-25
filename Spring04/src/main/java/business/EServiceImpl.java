package business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.EmpDAO;
import vo.EmpVO;

@Service("employee")
public class EServiceImpl implements EService {
	@Autowired //주입만 해주는 것 @Repository 해줬기 때문 
	private EmpDAO dao;
	
	@Override
	public ArrayList<EmpVO> selectList() {
		return dao.empList();
	}
	
	@Override
	public EmpVO selectOne(EmpVO vo) {
		return dao.eDetail(vo);
	}
	
	
	@Override
	public int insert(EmpVO vo) {
		return dao.eInsert(vo);
	}
	
	@Override
	public int delete(EmpVO vo) {
		return dao.eDelete(vo);
	}
	
	@Override
	public int update(EmpVO vo) {
	      return dao.eUpdate(vo);
	   }


}
