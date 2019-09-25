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

public class DeleteController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView() ;
		HttpSession session = request.getSession(false);
		String id = null;
		int cnt = 0;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		if (session != null) {
			id = (String) session.getAttribute("loginID");
			if (id != null) {
				// 2) Model(DAO) ȣ��
				if (id.equals("admin"))
					vo.setId(request.getParameter("id"));
				else
					vo.setId(id);
				cnt = dao.mDelete(vo);
				request.setAttribute("Apple", vo);
			} else
				System.out.println("**** loginID �� null ****");
		} else
			System.out.println("**** session �� null ****");
		// 3) response ó�� -> View (jsp) ȣ��
		if (cnt > 0) {
			if (id.equals("admin")) {
				mv.setViewName("redirect:/mlist.do");
				return mv;
			} else {
				session.invalidate();
				mv.addObject("fCode", "DS");
			}
		} else { // doFinish.jsp �� forward
			mv.addObject("fCode", "DF");
		}
		mv.setViewName("doFinish");
		return mv ;
	}
}  // class
