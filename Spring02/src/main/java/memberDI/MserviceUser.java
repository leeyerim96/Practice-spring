package memberDI;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import vo.MemberVO;

public class MserviceUser {

   public static void main(String[] args) {
     

      
      AbstractApplicationContext sc = new GenericXmlApplicationContext("memberDI/applicationC.xml");
      MService mem = (MService)sc.getBean("mm");
      MemberVO vo= (MemberVO)sc.getBean("vo");
      
      ArrayList<MemberVO> mList = mem.selectList();
      System.out.println("** memberList **");
      for (MemberVO mm:mList) {
         System.out.println("member : "+mm.toString());
      }
      System.out.println("** Login Test **");
      
      vo.setId("apple");
      vo.setPassword("12345");
      vo=mem.loginCheck(vo);
      if(vo!=null) {
         System.out.println("** login 성공 => id :" +vo.getId());
         
      }else 
         System.out.println("** login 실패");
   
      vo=mem.selectOne(vo);
      
      System.out.println("** detail test ");
      System.out.println(vo);
      
      
   }//main

}//class