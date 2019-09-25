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

// ** 스프링MVC 1단계 : 
// =>스프링 DispatcherServlet 사용 I 
// => xml 기반
//    스프링이 제공하는 DispatcherServlet , HandlerMapping , ViewResolver 
// => servlet-context.xml 에 정의 
//    각 Controller 는 스프링이 제공하는 Controller (Interface) 사용 
//    이때 오버라이딩 메서드명은 handleRequest , 리턴값은 ModelAndView  

// -> 1) interface Controller ( 클래스명위에서 Ctrl+클릭 눌러 확인 ) 
//  public interface Controller {
//	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
//  }
// -> 2) ModelAndView
//       컨트롤러의 return Type 을 처리해주는 클래스	

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
