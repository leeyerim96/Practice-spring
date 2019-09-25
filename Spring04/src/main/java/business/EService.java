package business;

import java.util.ArrayList;

import vo.EmpVO;


public interface EService {
	ArrayList<EmpVO> selectList();

	EmpVO selectOne(EmpVO vo);

	int insert(EmpVO vo);

	int delete(EmpVO vo);
	
	int update(EmpVO vo);

}
