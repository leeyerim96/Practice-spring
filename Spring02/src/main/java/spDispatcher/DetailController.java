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

public class DetailController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView() ;
		HttpSession session = request.getSession(false);
		String id = null;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		if (session != null) {
			id = (String) session.getAttribute("loginID");
			if (id != null) {
				if (id.equals("admin"))
					vo.setId(request.getParameter("id"));
				else
					vo.setId(id);
				vo = dao.mDetail(vo);
				mv.addObject("Apple", vo);
			} else
				System.out.println("**** loginID �� null ****");
		} else
			System.out.println("**** session �� null ****");
		// 3) response ó�� -> View (jsp) ȣ��
		if (vo != null && id != null) {
			mv.setViewName("detailView");
			return mv ;
		} else { // doFinish.jsp �� forward
			mv.addObject("fCode", "D");
			mv.setViewName("doFinish");
			return mv ;
		}
	} // handleRequest
} // class
