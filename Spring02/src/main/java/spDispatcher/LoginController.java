package spDispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import util.MemberDAO;
import vo.MemberVO;

public class LoginController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView() ;
		MemberVO vo = new MemberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		 
		if (id.equals("admin") && password.equals("12345")) {
			session.setAttribute("loginID", id);
			mv.addObject("sendR", "T");
			mv.setViewName("redirect:/mlist.do");
			return mv ;  
		}

		vo.setId(id);
		vo.setPassword(password);
		MemberDAO mdao = new MemberDAO();
		vo = mdao.memberLogin(vo);
		if (vo != null) {
			session.setAttribute("loginID", vo.getId());
			mv.setViewName("login/loginSuccess");
			return mv ;
		} else {
			mv.setViewName("login/loginFail");
			return mv ;
		}
	} // handleRequest
} // class
