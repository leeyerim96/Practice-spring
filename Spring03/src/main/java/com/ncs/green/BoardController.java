package com.ncs.green;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.BService;
import vo.BoardVO;
import vo.PageVO;

@Controller
public class BoardController {
   @Autowired
   private BService service;
   
   @RequestMapping(value="/plist")
	public ModelAndView plist(ModelAndView mv, PageVO pvo) {
		// Paging �غ�
	    // -> currPage : ù��û : pvo�� ����,
	    // 				pageNo click�ؼ� ��û�ϴ� ��� : pvo�� currPage�� set
		// -> currPage: start_Record ~ end_Record ��� 
	   
		int cpage=1 ;
		if (pvo.getCurrPage()>1) cpage=pvo.getCurrPage();
		else pvo.setCurrPage(cpage);
		// -> totalRocordCount: totalPage ��
		// DAO -> �ʿ��� ��ŭ�� select
		pvo = service.pageList(pvo);
		// -> totalPage �� ���
		int totalPage = pvo.getTotalCount()/
				pvo.getPerPage() ;
		if (pvo.getTotalCount()%pvo.getPerPage()!=0)
			totalPage++;
		
		// => ��� ��� 
		mv.addObject("totalPage",totalPage);
		mv.addObject("currPage",pvo.getCurrPage());
		mv.addObject("Banana",pvo.getList());
		mv.setViewName("board/pageList");
		return mv;
	} // plist
   
// ��� PageNo �����ϱ�
	// = 1ȭ�鿡 pageNo 3���� ����ϱ�
	@RequestMapping(value = "/plist2")
	public ModelAndView plist2(ModelAndView mv, PageVO pvo) {
		// 1. currPage (��û���� Page) ã��
		// => ó����û : 1 page
		// => pageList ���� ��û�� ���� ��� : pvo.getCurrPage()
		int currPage = 1;
		if (pvo.getCurrPage() > 1)
			 currPage = pvo.getCurrPage();
		else pvo.setCurrPage(currPage);
				
		// 2. DAO ó�� -> DB ���� ó��
		// -> totalRocordCount: totalPage ��
		// -> record�� ����� ��ŭ�� select
		pvo = service.pageList(pvo);
		// -> totalPage �� ���
		int totalPage = pvo.getTotalCount() / pvo.getPerPage();
		if (pvo.getTotalCount() % pvo.getPerPage() != 0)
			totalPage++;

		// 3. ����� startPage, endPage ã��
		// => perPageNo : �� ȭ�鿡 ��µǴ� PageNo ����
		int sPage = 1, ePage = 1;
		
		// ������� currPage=3 �̰� perPageNo �� 3 �̸� 1,2,3 page���� ��� �Ǿ�� �ϹǷ�
		// �Ʒ� ó�� currPage-1 �� perPageNo ���� ������.
		// currPage=11 -> 10,11,12, => (11-1)/3 * 3 +1 = 10 
		sPage = ((currPage - 1) / pvo.getPerPageNo()) * pvo.getPerPageNo() + 1;
		ePage = sPage + pvo.getPerPageNo() - 1;

		// 4. View ���� �ʿ��� �ڷḸ addObject
		mv.addObject("Banana", pvo.getList());
		mv.addObject("totalPage", totalPage);
		mv.addObject("currPage", currPage);
		mv.addObject("perPageNo", pvo.getPerPageNo());
		mv.addObject("sPage", sPage);
		mv.addObject("ePage", ePage);
		mv.setViewName("board/pageList2");
		return mv;
	} // plist2

   
   @RequestMapping(value="/blist")
   public ModelAndView blist(ModelAndView mv) {
      ArrayList<BoardVO> blist= service.selectList();
      mv.addObject("Banana",blist);
      mv.setViewName("board/boardList");
      return mv;
   } // blist
   
   @RequestMapping(value="/bdetail")
   public ModelAndView bdetail(HttpServletRequest request, ModelAndView mv,BoardVO vo) {
	   // ** ��ȸ�� ���� ��� �߰�
	   // => �α��� �� ����� �۾��̰� ���������� �Ǻ�
	   // => �������� �ƴ� ��쿡�� -> board ���� : count = count+1
	  String loId= null;
	  HttpSession session = request.getSession(false);
	  if(session != null) {
		 loId=(String)session.getAttribute("loginID");
		 //equals �񱳽ÿ� ������ null�� �ƴϿ�����
		 if(vo.getId()!=null && (!vo.getId().equals(loId))) {
			if(service.countUp(vo) > 0 ) {
				System.out.println("**CountUp ����!!");
			}else {
				System.out.println("**CountUp ����!!");
			}
		 }
	  }else {
		  System.out.println("** Controller bdeatil => session is null");
	  }
	  
      vo = service.selectOne(vo);
      if (vo==null) {
         System.out.println("** Controller bdetail => vo is null");
      }else {
    	 // ** ���ó���� ���� data����
    	 // => session�� ������ seq, root, step, indent ����
    	 session.setAttribute("root", vo.getRoot());
    	 session.setAttribute("step", vo.getStep());
    	 session.setAttribute("indent", vo.getIndent());
         mv.addObject("Apple",vo) ;
      }
      mv.setViewName("board/boardDetail");
      return mv;
   } // bdetail 
   
   @RequestMapping(value="/binsertf")
   public ModelAndView binserf(ModelAndView mv) {
      mv.setViewName("board/binsertForm");
      return mv;
   }
   @RequestMapping(value="/binsert")
   public ModelAndView binsert(ModelAndView mv, BoardVO vo) {
      int cnt = 0;
      cnt=service.insert(vo);
      if (cnt>0) {
         mv.setViewName("redirect:blist");
      }else {
         mv.addObject("fCode","I");
         mv.setViewName("board/boardFinish");
      }
      return mv;
   } // binsert
   
   @RequestMapping(value="/bupdate")
   public ModelAndView bupdate(ModelAndView mv, BoardVO vo) {
      int cnt = 0;
      cnt=service.update(vo);
      if (cnt>0) {
         mv.setViewName("redirect:blist");
      }else {
         mv.addObject("fCode","U");
         mv.setViewName("board/boardFinish");
      }
      return mv;
   } // bupdate 
   
   @RequestMapping(value="/bdelete")
   public ModelAndView bdelete(ModelAndView mv, BoardVO vo) {
	  // ��� �߰� ����
	  // => ������� �������� ���� �����ؾ� �� : root == seq �񱳰� �ʿ�
	  // => ������ ���� �ÿ��� ��� ��۵� ���� ���� : ��� ����� ã�� ���ؼ��� 
	  // => ��� : �ش�۸� �׳� ����� ��
	  // => ���� : ���� ��۵鵵 ��� �����.
	  // 
      int cnt = 0;
      cnt=service.delete(vo);
      if (cnt>0) {
         mv.setViewName("redirect:blist");
      }else {
         mv.addObject("fCode","D");
         mv.setViewName("board/boardFinish");
      }
      return mv;
   } // bdelete 
   
   
   @RequestMapping(value="/rinsertf")
   public ModelAndView rinserf(ModelAndView mv) {
      mv.setViewName("board/rinsertForm");
      return mv;
   }
   
   @RequestMapping(value="/rinsert")
   public ModelAndView rinsert(HttpServletRequest request, ModelAndView mv, BoardVO vo) {
	   // ������ seq, root, step, indent �� �ʿ�
	   // 1) =>  detail���� �� ������ session�� ����
	   // 2) => session�� �����ص� �θ��(����)�� root, step, indent get�Ͽ�
	   // 3)   �Է��Ϸ��� ����� root, step, indent�� ���
	   // step, indent�� 1�� ���� �����ָ� ��
	  int cnt = 0;
	  int pstep = 0;
	  int pindent=0;
	  HttpSession session = request.getSession(false);
	  if(session!=null) {
		  pstep=(Integer)session.getAttribute("step");
		  pindent=(Integer)session.getAttribute("indent");
	  }else System.out.println("** Controller rinsert => session is null");
	  
	  //vo�� set
	  vo.setStep(++pstep);
	  vo.setIndent(++pindent);
	  cnt = service.rinsert(vo);
	  if(cnt>0) mv.setViewName("redirect:blist");
	  else { 
		  mv.addObject("fCode", "RF");
		  mv.setViewName("board/boardFinish");
	  }  
	  return mv;
   }
   
} // class