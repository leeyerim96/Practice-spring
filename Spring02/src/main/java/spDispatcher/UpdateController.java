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

public class UpdateController implements Controller {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView() ;
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String birthd = request.getParameter("birthd");
		String pay = request.getParameter("pay");
		String weight = request.getParameter("weight");
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setBirthd(birthd);
		vo.setLev(lev);
		vo.setPay(Integer.parseInt(pay));
		vo.setWeight(Double.parseDouble(weight));
		// 2) DAO ȣ��
		int cnt = dao.mUpdate(vo);
		// 3) View ȣ��
		if (cnt > 0) {
			// �������� -> memberList ���
			mv.setViewName("redirect:/mlist.do");
			return mv ;
		} else {
			// �������� -> doFinish.jsp ���
			mv.addObject("fCode", "U");
			mv.setViewName("doFinish");
			return mv;
		} // else
	}
}  // class
