package business;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.MemberVO;

// Service Ŭ������ ����
// => Controller �� ��û�� ���� DAO �� �ش� �޼��带 ����
// => �׷��Ƿ� DAO�� ��� ����� ó���ϴ� �޼��� ����
// => Shift+art+T : interface �ڵ����� ����޴�

@Service("member")
public class MServiceimpl implements MService {
	
	@Inject //���Ը� ���ִ� �� @Repository ����� ���� 
	private SqlSession dao;

	// ��������(root-context.xml) �� ����
	// ������ �����̳ʰ� setSqlSessionFactory �޼��带 �ڵ�����
	// ������ ��������(root-context.xml)�� <bean> ��ϵ� Sql
	// �θ���  SqlSessionDaoSupport�� setSqlSessionFactor
	
	private static final String NS = "green.mapper.MemberMapper.";
	
	@Override
	public ArrayList<MemberVO> selectList() {
		return (ArrayList)dao.selectList(NS+"memberlist");
	}
	
	
	@Override public MemberVO selectOne(MemberVO vo) { 
		return dao.selectOne(NS+"selectDetail", vo); }
	  
	  @Override public MemberVO loginCheck(MemberVO vo) {
		  return dao.selectOne(NS+"loginMember", vo); }
	  
	  
	  @Override public int insert(MemberVO vo) { 
		  return dao.insert(NS+"insertMember",vo); }
	  
	  @Override public int delete(MemberVO vo) { 
		  return dao.delete(NS+"deleteMember",vo); }
	  
	  @Override public int update(MemberVO vo) { 
		  return dao.update(NS+"updateMember",vo); }
	 


	

}
