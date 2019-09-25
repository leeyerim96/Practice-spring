package iocDI04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

interface Speaker {
	public void volumeUp() ;
	public void volumeDown() ;
}

@Component("spa1")  // 이름이 없으면 못찾아서 beancreationException 오류가 남! 
class SpeakerA  implements Speaker {
	
	public SpeakerA() {
		System.out.println("** SpeakerAAA 생성 ~~");
	}
	
	public void volumeUp() {
		System.out.println("** SpeakerAAA volumeUp");
	}
	public void volumeDown() {
		System.out.println("** SpeakerAAA volumeDown");
	}
} // SpeakerA
@Component("spb1")
class SpeakerB  implements Speaker {
	
	public SpeakerB() {
		System.out.println("** SpeakerBBB 생성 ~~");
	}
	public void volumeUp() {
		System.out.println("** SpeakerBBB volumeUp");
	}
	public void volumeDown() {
		System.out.println("** SpeakerBBB volumeDown");
	}
} // SpeakerB

interface TV {
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}

@Component("tv1")
class LgTVs implements TV {
// Test1. 고전적 방법 : 직접 대입
// => 스피커 교체시 소스 수정 : 재컴파일	
	Speaker sp = new SpeakerB();

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

// Test2. 생성자를 통한 주입
@Component("tv2")
class SsTVs implements TV {
	
	//@Autowired
	//@Qualifier("spa")
	Speaker sp ;
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs 생성 ~~");
	}
	
	@Autowired
	public SsTVs(@Qualifier("spa")Speaker sp) {
		this.sp = sp;
		System.out.println("** SsTVs 생성자 : Speaker 만 주입");
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
@Component("tv3")
class AiTVs implements TV {
	
	//@Autowired
	//@Qualifier("spa")
	private Speaker speaker;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs 기본 생성자  ~~~");
	}
	
	@Autowired
	@Qualifier("spa")
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

public class TvUser07_Ano03 {

	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("iocDI04/applicationC07.xml");
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
