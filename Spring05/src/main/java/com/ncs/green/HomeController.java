package com.ncs.green;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import business.BService;
import business.MService;
import vo.BoardVO;
import vo.MemberVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Qualifier("member")
	private MService service ;
	
	@Autowired
	private BService bservice;
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} // home
	
	// Json �ѱ۱��� ó�� -> �ȵ� :response �� �ذ��
	//@RequestMapping(value="/jsbdetail",produces="application/json; charset=utf8")
	@RequestMapping(value="/jsbdetail")
	@ResponseBody
	public ModelAndView jsbdetail(ModelAndView mv, BoardVO vo, HttpServletResponse response) {
		
		response.setContentType("text/html;charset=UTF-8");
		vo=bservice.selectOne(vo);
		if (vo == null) 
			mv.addObject("content", "�۹�ȣ�� �ش��ϴ� �ڷᰡ �����ϴ�.~~");
		else 
			mv.addObject("content", vo.getContent());
		
		mv.setViewName("jsonView");
		return mv ;
	} // jsbdetail
	
	@RequestMapping(value="/jslogin")
	@ResponseBody
	public ModelAndView jslogin(ModelAndView mv, MemberVO vo) {
		
		vo=service.loginCheck(vo);
		if (vo!=null) { // ����
			mv.addObject("code",200);
		}else { // ����
			mv.addObject("code",201);
		}
		mv.setViewName("jsonView");
		return mv ;
	} // jslogin
	
	@RequestMapping(value="/ploginf")
	public ModelAndView ploginf(ModelAndView mv) {
		mv.setViewName("login/ploginForm");
		return mv ;
	}
	
	@RequestMapping(value="/pcalc")
	public ModelAndView pcalc(ModelAndView mv) {
		mv.setViewName("member/mycalc");
		return mv ;
	}
	
	@RequestMapping(value="/plogin")
	public ModelAndView plogin(ModelAndView mv, MemberVO vo) {
		
		mv.addObject("id",vo.getId());
		vo=service.loginCheck(vo);
		if (vo!=null) { // ����
			mv.addObject("loginR","T");
		}else { // ����
			mv.addObject("loginR","F");
		}
		mv.setViewName("login/ploginForm");
		return mv ;
	}
	
	@RequestMapping(value="/ajaxtest")
	public ModelAndView ajaxtest(ModelAndView mv) {
		mv.setViewName("ajaxTest/ajaxForm");
		return mv ;
	}
// *** AjaxTest  
	@RequestMapping(value="/amlist")
	public ModelAndView amlist(ModelAndView mv) {
		
		ArrayList<MemberVO> mlist = service.selectList();
		mv.addObject("Banana",mlist);
		mv.setViewName("ajaxTest/axmemberList");
		return mv; 
	}

	@RequestMapping(value="/idblist")
	public ModelAndView idblist(ModelAndView mv, BoardVO vo) {
		System.out.println("idblist BoardVO => "+vo);
		ArrayList<BoardVO> blist ;
		if (vo.getId()!=null) 
			 blist = bservice.idselectList(vo);
		else blist = bservice.selectList();
		
		mv.addObject("Banana", blist);
		mv.setViewName("ajaxTest/axBoardList");
		return mv; 
	} // idblist
	
	@RequestMapping(value="/axbdetail")
	public ModelAndView axbdetail(ModelAndView mv, BoardVO vo) {
		System.out.println("axbdetail BoardVO => "+vo);
		
		vo = bservice.selectOne(vo);
		if (vo == null) 
			System.out.println(" �۹�ȣ�� �ش��ϴ� �ڷᰡ �����ϴ�.~~ ");
		mv.addObject("Apple", vo);
		mv.setViewName("ajaxTest/axBDetail");
		return mv; 
	} // axbdetail
	
	@RequestMapping(value="/idcheck")
	public ModelAndView idcheck(ModelAndView mv, MemberVO vo) {
		// DB Ȯ��
		mv.addObject("id",vo.getId()) ;
		vo=service.selectOne(vo);
		if (vo!=null) { // ��� �Ұ���
			mv.addObject("idCheck","F");
		}else { // ��밡��
			mv.addObject("idCheck","T");
		}
		// ��� ���
		mv.setViewName("member/idCheck");
		return mv;
	} // idcheck
	
	@RequestMapping(value="/loginf")
	public ModelAndView loginf(ModelAndView mv) {
		// *** Exception Test
		// ArithmeticException Test
		//int i = 100/0 ;
		// IllegalArgumentException
		//String abc=null;
		//int i = Integer.parseInt(abc) ; 
		// NullPointerException 
		//if (abc.equals("test")) System.out.println("** NullPointerException Test1 ~~");
		// NullPointerException �� ���� �� �� �ִ� equals 
		//if ("test".equals(abc)) 
		//	System.out.println("** NullPointerException abc==test ~~");
		//else System.out.println("** NullPointerException abc!=test ~~");
		
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
		if (id.equals("admin") && password.equals("yerim96!")) {
			session.setAttribute("loginID", id);
			mv.setViewName("redirect:/mlist");
			return mv ;  
		}
		vo = service.loginCheck(vo);
		if (vo != null) {
			session.setAttribute("loginID", vo.getId());
			mv.setViewName("login/loginSuccess");
		} else {
			mv.addObject("fail","true");
			mv.setViewName("login/loginForm");
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
		
		// Ajax Test  ���� �߰�
		System.out.println("aJoin Test =>"+vo);
		MultipartFile uploadfilef=null;
		if (vo.getUploadfilef()!=null) {
			uploadfilef = vo.getUploadfilef() ;
		}
		String file1, file2="No Image" ;
		
		//if (!uploadfilef.isEmpty()) {
		if (uploadfilef!=null) {
			file1="D:/MTest/MyWork/Spring05/src/main/webapp/resources/uploadImage/"
					+uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));
			file2="resources/uploadImage/"+uploadfilef.getOriginalFilename();
		}else System.out.println("** UploadImage �� �������� ���� ~~");
		
		vo.setUploadfile(file2);
		
		int cnt = service.insert(vo);
		// RollBack Test ���� �ݺ� �Է� �ڵ� �߰�
		// int cnt1 = service.insert(vo) ;  
		// Key �ߺ� ���� �߻� 
		// => transaction ó���� �ȵȴٸ�
		//    : ù��°�� �Է� �ǰ�(AutoCommit), �ι�°�� ���� 
		// => transaction ó���� �ȴٸ� 
		//    : Rollback �ǹǷ� ��� �Է� �ȵ� 
		
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
		// => vo�� uploadfilef , uploadfile ��� ���� Ȱ��
		
		System.out.println("from form uploadfile=>"+vo.getUploadfile());
		
		MultipartFile uploadfilef = vo.getUploadfilef();
		String file1, file2="No Image" ;
		// �� �̹����� ���� �� ��쿡�� ������
		if (!uploadfilef.isEmpty()) {
			file1="D:/MTest/MyWork/Spring05/src/main/webapp/resources/uploadImage/"
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
