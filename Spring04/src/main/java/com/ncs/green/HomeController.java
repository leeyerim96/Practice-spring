package com.ncs.green;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
import org.springframework.web.servlet.ModelAndView;

import business.EService;

import vo.EmpVO;

@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   @Qualifier("employee")
   private EService service;
   
   @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      return "home";
   }
   
   @RequestMapping(value="/joinf")
   public ModelAndView joinf(ModelAndView mv) {
      mv.setViewName("employee/empJoinForm");
      return mv ;
   }
   
   @RequestMapping(value="/elist")
   public ModelAndView elist(ModelAndView mv) {
      ArrayList<EmpVO> elist = service.selectList();
      mv.addObject("banana",elist);
      mv.setViewName("employee/empList");
      return mv; 
   }
   
   @RequestMapping(value="/edetail")
   public ModelAndView edetail(HttpServletRequest request,
         ModelAndView mv, EmpVO vo) {
      
     
         vo = service.selectOne(vo);
         mv.addObject("banana", vo);
     
      // 3) response 처리 -> View (jsp) 호출
      if (vo != null) {
         mv.setViewName("employee/empDetail");
      } else { // doFinish.jsp 로 forward
         mv.addObject("fCode", "D");
         mv.setViewName("employee/doFinish");
      }
      return mv; 
   } // edetail
   
   @RequestMapping(value="/ejoin")
	public ModelAndView ejoin(ModelAndView mv, EmpVO vo) {
		int cnt = service.insert(vo);
		if (cnt > 0) {
			// Join성공 -> List 출력
			mv.setViewName("redirect:/elist");
			mv.addObject("joinID", vo.getId());
			mv.addObject("fCode", "JS");
		} else {
			// Join실패 -> doFinish.jsp 출력
			mv.addObject("fCode", "JF");
			mv.setViewName("employee/doFinish");
		} // else
		
		return mv;	
	} // ejoin
	
	@RequestMapping(value="/eupdate")
	public ModelAndView mupdate(ModelAndView mv, EmpVO vo) {
		
		int cnt =  service.update(vo);
		if (cnt > 0) {
			// 수정성공 -> memberList 출력
			mv.setViewName("redirect:/elist");
		} else {
			// 수정실패 -> doFinish.jsp 출력
			mv.addObject("fCode", "U");
			mv.setViewName("employee/doFinish");
		} // else
		return mv;
	} // eupdate
	
	 @RequestMapping(value = "edelete")
	   public ModelAndView edelete(EmpVO vo, ModelAndView mv) {

	      int cnt = service.delete(vo);

	      if (cnt > 0) {
	         mv.setViewName("redirect:/elist");
	         return mv;
	      } else {
	         mv.addObject("fCode", "DF");
	         mv.setViewName("/employee/doFinish");
	         return mv;
	      }
	   }
   
}