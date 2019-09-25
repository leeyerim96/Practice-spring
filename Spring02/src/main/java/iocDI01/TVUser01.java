package iocDI01;

interface TV {
   public void powerOn();
   public void powerOff();
   public void volumeUp();
   public void volumeDown();
}

class LgTV implements TV {
   
   public LgTV() {
      System.out.println("** LgTV 생성 ~~");
   }
   
   public void powerOn() {
      System.out.println("** LgTV 전원 On");
   }
   public void powerOff() {
      System.out.println("** LgTV 전원 Off");
   }
   public void volumeUp() {
      System.out.println("** LgTV volumeUp");
   }
   public void volumeDown() {
      System.out.println("** LgTV volumeDown");
   }
} // LgTV

class SsTV implements TV {
   
   public SsTV() {
      System.out.println("** SsTV 생성 ~~");
   }
   
   public void powerOn() {
      System.out.println("** SsTV 전원 On");
   }
   public void powerOff() {
      System.out.println("** SsTV 전원 Off");
   }
   public void volumeUp() {
      System.out.println("** SsTV soundUp");
   }
   public void volumeDown() {
      System.out.println("** SsTV soundDown");
   }
} // SsTV

class BeanFactory {
   public TV getBean(String name) {
      if (name.equals("ss")) return new SsTV() ;
      else if (name.equals("lg")) return new LgTV() ;
      else return null ;
   } // getBean
} // BeanFactory

public class TVUser01 {

   public static void main(String[] args) {
      /*
       * LgTV tv = new LgTV();
       * tv.powerOn();
       * tv.volumeUp();
       * tv.volumeDown();
       * tv.powerOff();
       */
   // => TV교체 1   
      // SsTV tv = new SsTV();
   // => TV교체 2 : interface , 다형성 적용   
   //    그래도 소스의 수정이 필요함   
      // TV tv = new SsTV() ;
      //TV tv = new LgTV() ;
      //tv.powerOn();
      //tv.volumeUp();
      //tv.volumeDown();
      //tv.powerOff();
   // => TV교체 3 : Factory 패턴 : BeanFactory   
   // => Bean : 하나의 컴파일 된 클래스
   // => JavaBeans : 재사용 과 공유가 가능한
//                      소프트웨어 개체를 만들 수 있게 하는 컴포넌트 기술.
      BeanFactory bf = new BeanFactory() ;
      TV tv = bf.getBean("ss") ;
      tv.powerOn();
      tv.volumeUp();
      tv.volumeDown();
      tv.powerOff();
   } // main
} // TVUser01