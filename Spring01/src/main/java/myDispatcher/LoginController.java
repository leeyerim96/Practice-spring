package myDispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberDAO;
import vo.MemberVO;

public class LoginController implements Controller {
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		 
		if (id.equals("admin") && password.equals("12345")) {
			session.setAttribute("loginID", id);
			request.setAttribute("sendR", "T");
			return "Spring01/mlist.do" ;  
		}

		vo.setId(id);
		vo.setPassword(password);
		MemberDAO mdao = new MemberDAO();
		vo = mdao.memberLogin(vo);
		if (vo != null) {
			session.setAttribute("loginID", vo.getId());
			return "login/loginSuccess";
		} else {
			return "login/loginFail";
		}
	} // handleRequest
} // class
