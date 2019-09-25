package iocDI01;

interface TV {
   public void powerOn();
   public void powerOff();
   public void volumeUp();
   public void volumeDown();
}

class LgTV implements TV {
   
   public LgTV() {
      System.out.println("** LgTV ���� ~~");
   }
   
   public void powerOn() {
      System.out.println("** LgTV ���� On");
   }
   public void powerOff() {
      System.out.println("** LgTV ���� Off");
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
      System.out.println("** SsTV ���� ~~");
   }
   
   public void powerOn() {
      System.out.println("** SsTV ���� On");
   }
   public void powerOff() {
      System.out.println("** SsTV ���� Off");
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
   // => TV��ü 1   
      // SsTV tv = new SsTV();
   // => TV��ü 2 : interface , ������ ����   
   //    �׷��� �ҽ��� ������ �ʿ���   
      // TV tv = new SsTV() ;
      //TV tv = new LgTV() ;
      //tv.powerOn();
      //tv.volumeUp();
      //tv.volumeDown();
      //tv.powerOff();
   // => TV��ü 3 : Factory ���� : BeanFactory   
   // => Bean : �ϳ��� ������ �� Ŭ����
   // => JavaBeans : ���� �� ������ ������
//                      ����Ʈ���� ��ü�� ���� �� �ְ� �ϴ� ������Ʈ ���.
      BeanFactory bf = new BeanFactory() ;
      TV tv = bf.getBean("ss") ;
      tv.powerOn();
      tv.volumeUp();
      tv.volumeDown();
      tv.powerOff();
   } // main
} // TVUser01