package anoDispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.MemberVO;

//** 스프링MVC 3단계 : 
//=>스프링 DispatcherServlet 사용 III 

//=> @ , xml 기반
//
//** @Component 의 세분화 
//=> 스프링 프레임워크에서는 클래스들을 기능별로 분류하기위해 @ 을 추가함.
//=>  @Controller :사용자요청을 제어하는 Controller 클래스
//			      DispatcherServlet이 해당 객체를 Controller객체로 인식하게해줌. 	
//=>  @Service : 비즈니스로직을 담당하는 Service 클래스  => ServiceImpl
//=>  @Repository :DB 연동을 담당하는 DAO 클래스            => DAO
//			   DB 연동과정에서 발생하는 예외를 변환 해주는 기능 추가 	

//1. @Controller 사용함
//=> implements Controller 를 대신함.
//=> 이와 관련된 import 삭제 해야 함.
//public class LoginController implements Controller {
//=> 메서드명은 handleRequest 사용안해도 됨
//=> 리턴값은 ModelAndView 또는 String 가능함
//2. xml 수정
//=> HandlerMapping 
//	@RequestMapping 으로 대체되므로 삭제
//=> ViewResolver 는 사용해도 되고 안해도 됨
//=> 삭제하고 사용안하려면 소스의 viewPath 의  .jsp 경로 수정해야함 
//3. Business(Service) Layer 작성

@Controller
public class MController {
	@Autowired
	MService dao ; 
	
	@RequestMapping(value="/mlist.do")
	// value="/login.do" : 이때 호출되는 메서드명과 동일하면 value 생략가능
	// HandlerMapping 을 대체함  
	// 스프링 프레임p의 Controller를 구현 하지 않기 때문에 메서드명이나 인자의 처리가 자유로움 
	public ModelAndView list(ModelAndView mv)
			throws ServletException, IOException {
		
		ArrayList<MemberVO> mList = dao.selectList() ; 
		mv.addObject("Orange",mList);
		mv.setViewName("memberList"); 
		return mv ;
	} // list
	
	@RequestMapping(value="/join.do")
	public ModelAndView join(ModelAndView mv, MemberVO vo)
			throws ServletException, IOException {
		
		System.out.println("Join Test vo Value=>\n"+vo);
		int cnt = dao.insert(vo) ;
		// 입력결과 : 성공-> 회원가입 완료, 로그인 하세요  / 실패 ->  실패 이유, 실패 했으니 다시 하세요 ~~ 
		mv.addObject("joinId", vo.getId());
		if (cnt>0) {
			mv.addObject("isJoin", "T");
			mv.addObject("cnt", cnt);
		}else {
			mv.addObject("isJoin", "F");
		}
		// 결과 출력 -> JSP 로	
		mv.setViewName("joinFinish"); 
		return mv ;
	} // list
	
} // class
