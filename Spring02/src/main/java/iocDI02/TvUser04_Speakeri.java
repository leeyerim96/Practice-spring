package iocDI02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

interface Speaker {
	public void volumeUp() ;
	public void volumeDown() ;
}

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

//DI : ������ ���� -> �ܺο��� Control -> (������ ���� :IOC)
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
class SsTVs implements TV {

	Speaker sp ;
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs ���� ~~");
	}

	public SsTVs(Speaker sp) {
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
// => Speaker �� ���� �ޱ����� Setter �޼��� �߰�
// => ����ȭ�Ͽ� �±� �߰�
// setter �޼���� <bean> ���� ���� �����̳ʰ� �ڵ� ȣ�� ��.
// �̶� �Ű������� ���� �������ָ� ��.
// -> <property> �� ����
class AiTVs implements TV {
	private Speaker speaker;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs �⺻ ������  ~~~");
	}
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

public class TvUser04_Speakeri {

	public static void main(String[] args) {
		AbstractApplicationContext sc = new GenericXmlApplicationContext("iocDI02/applicationC04.xml");
		System.out.println("** Test 1 : ������ ��� (���� ����)");
		TV tv = (TV) sc.getBean("tv");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		System.out.println("** Test 2 : �����ڸ� ���� ����");
		TV tvs = (TV) sc.getBean("tvs");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();
		System.out.println("** Test 3 : setter �޼��带 ���� ����");
		TV tva = (TV) sc.getBean("tva");
		tvs.powerOn();
		tvs.volumeDown();
		tvs.volumeUp();
		tvs.powerOff();

		sc.close();
	} // main
} // class
