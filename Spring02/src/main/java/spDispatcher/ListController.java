package spDispatcher;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import util.MemberDAO;
import vo.MemberVO;

// ** ������MVC 1�ܰ� : 
// =>������ DispatcherServlet ��� I 
// => xml ���
//    �������� �����ϴ� DispatcherServlet , HandlerMapping , ViewResolver 
// => servlet-context.xml �� ���� 
//    �� Controller �� �������� �����ϴ� Controller (Interface) ��� 
//    �̶� �������̵� �޼������ handleRequest , ���ϰ��� ModelAndView  

// -> 1) interface Controller ( Ŭ������������ Ctrl+Ŭ�� ���� Ȯ�� ) 
//  public interface Controller {
//	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
//  }
// -> 2) ModelAndView
//       ��Ʈ�ѷ��� return Type �� ó�����ִ� Ŭ����	

public class ListController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView() ;
		MemberDAO dao = new MemberDAO() ;
		ArrayList<MemberVO> mlist = dao.memberList() ;
		mv.addObject("banana",mlist);
		mv.setViewName("memberList");
		return mv ;
	}
}  // class
