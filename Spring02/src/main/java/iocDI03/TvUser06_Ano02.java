package iocDI03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Speaker {
	public Speaker() {
		System.out.println("** Speaker ���� ~~");
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
// Test1. ������ ��� : ���� ����	
	Speaker sp = new Speaker();

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

//@Autowired 
//=> �ڵ����� , ������ ���� , ������ Exception �߻�
//=> �������
//1) �ַ� ������� ���� �����ϸ�,
//	  ������ �����̳ʴ� �ش纯���� Ÿ���� üũ�ϰ�,
//	  �� Ÿ���� ��ü�� �޸𸮿� �����ϴ��� Ȯ���Ͽ�
//	  �ش� ������ ���� ���ش�.
//2) ����Ÿ���� ��ü�� ���̻��̸�  @Qualifier �� ��õ� ��ü ����
//3) ����Ÿ���� ��ü�� ���̻��̰�  @Qualifier ������ id�� ���� ��ü ã�� ������ ����, ������ ����
	
//@Autowired(required=false) 
//=> ���������� , ������ null �� => main ����� NullPointerException �߻� 
	
//test1 => Speaker ���� �ȵȰ�� : �����޽��� Ȯ��
//		 => ...Injection of autowired dependencies failed;.....
//test2 => Speaker ���� �Ȱ��

// Test2. �����ڸ� ���� ����
@Component("tv2")
class SsTVs implements TV {
	// �ɹ������� ���� ������ �ּҰ��� ����
	//@Autowired(required=false)
	Speaker sp ;
	// Speaker sp = new Speaker();
	// = : @Autowired , ���Թ� 
	// new Speaker() : @Component ,������ 
	
	int price ;
	String sno ;

	public SsTVs() {
		System.out.println("** SsTVs ���� ~~");
	}
	
	@Autowired(required=false)
	public SsTVs(Speaker sp) {
		this.sp = sp;
		System.out.println("** SsTVs ������ : Speaker���� ~~");
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

@Component("tv3")
class AiTVs implements TV {
	
	//@Autowired(required=false)
	private Speaker speaker;
	private int price;
	
	public AiTVs() {
		System.out.println("** AiTVs �⺻ ������  ~~~");
	}
	@Autowired(required=false)
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

public class TvUser06_Ano02 {

	public static void main(String[] args) {
		AbstractApplicationContext sc = new GenericXmlApplicationContext("iocDI03/applicationC05.xml");
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
