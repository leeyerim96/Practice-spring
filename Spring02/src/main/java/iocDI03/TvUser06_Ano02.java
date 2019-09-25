package iocDI03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Speaker {
	public Speaker() {
		System.out.println("** Speaker 생성 ~~");
	}
	public void volumeUp() {
		System.out.println("** Speaker volumeUp");
	}
	public void volumeDown() {
		System.out.println("** Speaker volumeDown");
	}
} // Speaker

@Component("tv1")
class LgTVs implements TV {
// Test1. 고전적 방법 : 직접 대입	
	Speaker sp = new Speaker();

	public LgTVs() {
		System.out.println("** LgTVs 생성 ~~");
	}

	public void powerOn() {
		System.out.println("** LgTV 전원 On");
	}

	public void powerOff() {
		System.out.println("** LgTV 전원 Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}

} // LgTV

//@Autowired 
//=> 자동주입 , 있으면 주입 , 없으면 Exception 발생
//=> 적용순위
//1) 주로 멤버변수 위에 선언하며,
//	  스프링 컨테이너는 해당변수의 타입을 체크하고,
//	  그 타입의 객체가 메모리에 존재하는지 확인하여
//	  해당 변수에 대입 해준다.
//2) 동일타입의 객체가 둘이상이면  @Qualifier 에 명시된 객체 주입
//3) 동일타입의 객체가 둘이상이고  @Qualifier 없으면 id가 같은 객체 찾아 있으면 주입, 없으면 오류
	
//@Autowired(required=false) 
//=> 있으면주입 , 없으면 null 값 => main 실행시 NullPointerException 발생 
	
//test1 => Speaker 생성 안된경우 : 오류메시지 확인
//		 => ...Injection of autowired dependencies failed;.....
//test2 => Speaker 생성 된경우

// Test2. 생성자를 통한 주입
@Component("tv2")
class SsTVs implements TV {
	// 맴버변수에 직접 생성된 주소값을 전달
	//@Autowired(required=false)
	Speaker sp ;
	// Speaker sp = new Speaker();
	// = : @Autowired , 대입문 
	// new Speaker() : @Component ,생성문 
	
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs 생성 ~~");
	}
	
	@Autowired(required=false)
	public SsTVs(Speaker sp) {
		this.sp = sp;
		System.out.println("** SsTVs 생성자 : Speaker주입 ~~");
	}
	
	public SsTVs(Speaker sp, String sno, int p) {
		this.sp = sp;
		this.price=p;
		this.sno=sno;
		System.out.println("** SsTVs 생성자 : Speaker주입 ~~Price, sno =>"
							+price+" , "+sno);
	}

	public void powerOn() {
		System.out.println("** SsTV 전원 On");
	}

	public void powerOff() {
		System.out.println("** SsTV 전원 Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}
} // SsTV

//Test3. Setter 메서드를 통해 Speaker를 주입 받기
// => Speaker 를 주입 받기위한 Setter 메서드 추가
// => 설정화일에 태그 추가
// setter 메서드는 <bean> 생성 직후 컨테이너가 자동 호출 함.
// 이때 매개변수의 값만 전달해주면 됨.
// -> <property> 로 설정

@Component("tv3")
class AiTVs implements TV {
	
	//@Autowired(required=false)
	private Speaker speaker;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs 기본 생성자  ~~~");
	}
	@Autowired(required=false)
	public void setSpeaker(Speaker sp) {
		System.out.println("** AiTVs : Speaker 를 주입 받기위한 Setter  ~~~");
		this.speaker = sp;
	}
	public void setPrice(int price) {
		System.out.println("** AiTVs : price 값 를 주입 받기위한 Setter  ~~~");
		System.out.println("** AiTVs Setter price =>" + price);
		this.price = price;
	}
	public void powerOn() {
		System.out.println("** AiTVs 전원 ON ~~~");
	}
	public void powerOff() {
		System.out.println("** AiTVs 전원 OFF ~~~");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
} // SsTVs

public class TvUser06_Ano02 {

	public static void main(String[] args) {
		AbstractApplicationContext sc = new GenericXmlApplicationContext("iocDI03/applicationC05.xml");
		System.out.println("** Test 1 : 고전적 방법 (직접 대입)");
		TV tv = (TV) sc.getBean("tv1");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		System.out.println("** Test 2 : 생성자를 통한 주입");
		TV tvs = (TV) sc.getBean("tv2");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();
		System.out.println("** Test 3 : setter 메서드를 통한 주입");
		TV tva = (TV) sc.getBean("tv3");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();

		sc.close();
	} // main
} // class
