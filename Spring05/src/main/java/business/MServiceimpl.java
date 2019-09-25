package business;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.MemberVO;

// Service 클래스의 역할
// => Controller 의 요청에 따라 DAO 의 해당 메서드를 실행
// => 그러므로 DAO의 모든 기능을 처리하는 메서드 구현
// => Shift+art+T : interface 자동생성 단축메뉴

@Service("member")
public class MServiceimpl implements MService {
	
	@Inject //주입만 해주는 것 @Repository 해줬기 때문 
	private SqlSession dao;

	// 설정파일(root-context.xml) 에 의해
	// 스프링 컨테이너가 setSqlSessionFactory 메서드를 자동으로
	// 스프링 설정파일(root-context.xml)에 <bean> 등록된 Sql
	// 부모인  SqlSessionDaoSupport에 setSqlSessionFactor
	
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
