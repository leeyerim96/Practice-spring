package com.ncs.green;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import business.MService;
import vo.MemberVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("member")
	private MService service ;
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} // home

	
	@RequestMapping(value="/loginf")
	public ModelAndView loginf(ModelAndView mv) {
		mv.setViewName("login/loginForm");
		return mv ;
	}
	
	@RequestMapping(value="/joinf")
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("member/joinForm");
		return mv ;
	}
	
	@RequestMapping(value="/mlist")
	public ModelAndView mlist(ModelAndView mv) {
		ArrayList<MemberVO> mlist = service.selectList();
		mv.addObject("Banana",mlist);
		mv.setViewName("member/memberList");
		return mv; 
	}
	@RequestMapping(value="/login")
	public ModelAndView mlogin(HttpServletRequest request,
							ModelAndView mv, MemberVO vo) {
		String id = vo.getId();
		String password = vo.getPassword();
		HttpSession session = request.getSession();
		if (id.equals("admin") && password.equals("12345")) {
			session.setAttribute("loginID", id);
			mv.setViewName("redirect:/mlist");
			return mv ;  
		}
		vo = service.loginCheck(vo);
		if (vo != null) {
			session.setAttribute("loginID", vo.getId());
			mv.setViewName("login/loginSuccess");
		} else {
			mv.setViewName("login/loginFail");
		}
		return mv; 
	} // mlogin
	
	@RequestMapping(value="/logout")
	public ModelAndView mlogout(HttpServletRequest request,
							ModelAndView mv) {
		request.getSession().invalidate();
		mv.setViewName("home");
		return mv;
	} // mlogout
	
	@RequestMapping(value="/mdetail")
	public ModelAndView mdetail(HttpServletRequest request,
			ModelAndView mv, MemberVO vo) {
		
		String id = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("loginID");
			if (id != null) {
				if (!id.equals("admin")) vo.setId(id);
				vo = service.selectOne(vo);
				mv.addObject("Apple", vo);
			} else
				System.out.println("**** loginID �� null ****");
		} else
			System.out.println("**** session �� null ****");
		// 3) response ó�� -> View (jsp) ȣ��
		if (vo != null && id != null) {
			mv.setViewName("member/detailView");
		} else { // doFinish.jsp �� forward
			mv.addObject("fCode", "D");
			mv.setViewName("member/doFinish");
		}
		return mv; 
	} // mdetail
	@RequestMapping(value="/mjoin")
	public ModelAndView mjoin(ModelAndView mv, MemberVO vo) 
				throws ServletException, IOException {
		// Image ó��
		// => Form -> vo : MultipartFile Type
		// => MultipartFile Type : image����, table�� ������ ���/ȭ�ϸ� �����
		// => vo -> table : String Type
		
		MultipartFile uploadfilef = vo.getUploadfilef();
		String file1, file2="No Image" ;
		
		if (!uploadfilef.isEmpty()) {
			file1="D:/MTest/MyWork/Spring03/src/main/webapp/resources/uploadImage/"
					+uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));
			file2="resources/uploadImage/"+uploadfilef.getOriginalFilename();
		}else System.out.println("** UploadImage �� �������� ���� ~~");
		
		vo.setUploadfile(file2);
		int cnt = service.insert(vo);
		if (cnt > 0) {
			// Join���� -> memberList ���
			mv.addObject("joinID", vo.getId());
			mv.addObject("fCode", "JS");
		} else {
			// Join���� -> doFinish.jsp ���
			mv.addObject("fCode", "JF");
		} // else
		mv.setViewName("member/doFinish");
		return mv;	
	} // mjoin
	
	@RequestMapping(value="/mupdate")
	public ModelAndView mupdate(ModelAndView mv, MemberVO vo) 
			throws ServletException, IOException {
		// �������� �̹��� ȭ�ϸ��� detailView form �� hidden���� �����ߴٰ� ����� 
		// vo �� ���޵� Ȯ�� 
		System.out.println("from form uploadfile=>"+vo.getUploadfile());
		
		MultipartFile uploadfilef = vo.getUploadfilef();
		String file1, file2="No Image" ;
		// �� �̹����� ���� �� ��쿡�� ������
		if (!uploadfilef.isEmpty()) {
			file1="D:/MTest/MyWork/Spring03/src/main/webapp/resources/uploadImage/"
					+uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));
			file2="resources/uploadImage/"+uploadfilef.getOriginalFilename();
			vo.setUploadfile(file2);
		}else System.out.println("** UploadImage �� �������� ���� ~~");
		
		
		int cnt =  service.update(vo);
		if (cnt > 0) {
			// �������� -> memberList ���
			mv.setViewName("redirect:/mlist");
		} else {
			// �������� -> doFinish.jsp ���
			mv.addObject("fCode", "U");
			mv.setViewName("member/doFinish");
		} // else
		return mv;
	} // mupdate
	
	@RequestMapping(value="/mdelete")
	public ModelAndView mdelete(HttpServletRequest request,
			ModelAndView mv, MemberVO vo) {
		
		
		String id = null;
		int cnt = 0;
		HttpSession session = request.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("loginID");
			if (id != null) {
				// 2) Model(DAO) ȣ��
				if (!id.equals("admin")) vo.setId(id);
				cnt = service.delete(vo);
				mv.addObject("Apple", vo);
			} else
				System.out.println("**** loginID �� null ****");
		} else
			System.out.println("**** session �� null ****");
		
		if (cnt > 0) {
			if (id.equals("admin")) {
				mv.setViewName("redirect:/mlist");
				return mv;
			} else {
				session.invalidate();
				mv.addObject("fCode", "DS");
			}
		} else { // doFinish.jsp �� forward
			mv.addObject("fCode", "DF");
		}
		mv.setViewName("member/doFinish");
		return mv;
	} // mdelete
	
} // class
