package myDispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberDAO;
import vo.MemberVO;

public class DeleteController implements Controller {
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
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
				return "/Spring01/mlist.do";
			} else {
				session.invalidate();
				request.setAttribute("fCode", "DS");
			}
		} else { // doFinish.jsp �� forward
			request.setAttribute("fCode", "DF");
		}
		return "doFinish" ;
	}
}  // class
