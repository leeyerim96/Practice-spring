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

@Component("spa1")  // �̸��� ������ ��ã�Ƽ� beancreationException ������ ��! 
class SpeakerA  implements Speaker {
	
	public SpeakerA() {
		System.out.println("** SpeakerAAA ���� ~~");
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
		System.out.println("** SpeakerBBB ���� ~~");
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
// Test1. ������ ��� : ���� ����
// => ����Ŀ ��ü�� �ҽ� ���� : ��������	
	Speaker sp = new SpeakerB();

	public LgTVs() {
		System.out.println("** LgTVs ���� ~~");
	}

	public void powerOn() {
		System.out.println("** LgTV ���� On");
	}

	public void powerOff() {
		System.out.println("** LgTV ���� Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}

} // LgTV

// Test2. �����ڸ� ���� ����
@Component("tv2")
class SsTVs implements TV {
	
	//@Autowired
	//@Qualifier("spa")
	Speaker sp ;
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs ���� ~~");
	}
	
	@Autowired
	public SsTVs(@Qualifier("spa")Speaker sp) {
		this.sp = sp;
		System.out.println("** SsTVs ������ : Speaker �� ����");
	}
	
	public SsTVs(Speaker sp, String sno, int p) {
		this.sp = sp;
		this.price=p;
		this.sno=sno;
		System.out.println("** SsTVs ������ : Speaker���� ~~Price, sno =>"
							+price+" , "+sno);
	}

	public void powerOn() {
		System.out.println("** SsTV ���� On");
	}

	public void powerOff() {
		System.out.println("** SsTV ���� Off");
	}

	public void volumeUp() {
		sp.volumeUp();
	}

	public void volumeDown() {
		sp.volumeDown();
	}
} // SsTV

//Test3. Setter �޼��带 ���� Speaker�� ���� �ޱ�
@Component("tv3")
class AiTVs implements TV {
	
	//@Autowired
	//@Qualifier("spa")
	private Speaker speaker;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs �⺻ ������  ~~~");
	}
	
	@Autowired
	@Qualifier("spa")
	public void setSpeaker(Speaker sp) {
		System.out.println("** AiTVs : Speaker �� ���� �ޱ����� Setter  ~~~");
		this.speaker = sp;
	}
	public void setPrice(int price) {
		System.out.println("** AiTVs : price �� �� ���� �ޱ����� Setter  ~~~");
		System.out.println("** AiTVs Setter price =>" + price);
		this.price = price;
	}
	public void powerOn() {
		System.out.println("** AiTVs ���� ON ~~~");
	}
	public void powerOff() {
		System.out.println("** AiTVs ���� OFF ~~~");
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
		System.out.println("** Test 1 : ������ ��� (���� ����)");
		TV tv = (TV) sc.getBean("tv1");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		System.out.println("** Test 2 : �����ڸ� ���� ����");
		TV tvs = (TV) sc.getBean("tv2");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();
		System.out.println("** Test 3 : setter �޼��带 ���� ����");
		TV tva = (TV) sc.getBean("tv3");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();

		sc.close();
	} // main
} // class
