package anoDispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.MemberVO;

// ** ������MVC 2�ܰ� : 
// =>������ DispatcherServlet ��� II 
// => Annotation ���

public class ListController implements Controller {
	@Autowired
	MService dao ;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView() ;
		//MemberDAO dao = new MemberDAO() ;
		ArrayList<MemberVO> mlist = dao.selectList() ;
		mv.addObject("banana",mlist);
		mv.setViewName("memberList");
		return mv ;
	}
}  // class
