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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.BService;
import vo.BoardVO;

@Controller
public class HomeController {
	
	@Autowired
	private BService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/blist")
	public ModelAndView blist(ModelAndView mv) {
		ArrayList<BoardVO> blist = service.selectList();
		mv.addObject("Banana", blist);
		mv.setViewName("board/boardList");
		return mv;
	} // blist

	@RequestMapping(value = "/bdetail")
	public ModelAndView bdetail(HttpServletRequest request, ModelAndView mv, BoardVO vo) {

		vo = service.selectOne(vo);
		if (vo == null) {
			System.out.println("** Controller bdetail => vo is null");
		} else {
			mv.addObject("Apple", vo);
		}
		mv.setViewName("board/boardDetail");
		return mv;
	} // bdetail
	
} // class
