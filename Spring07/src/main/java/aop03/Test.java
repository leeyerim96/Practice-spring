package aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		// ** Ioc/DI => Spring �����̳ʷκ��� ���Թޱ�
		AbstractApplicationContext ck = new GenericXmlApplicationContext("aop03/appCon.xml");
		Person cookerb = (Person)ck.getBean("cookerb");
		Person cooker = (Person)ck.getBean("cooker");
		try {
			System.out.println("**Boy Test**");
			cookerb.doSomething();
			System.out.println("**Girl Test**");
			cooker.doSomething();
		}catch (Exception e) {
			System.out.println("main Exception =>"+e.toString());
		}
		ck.close();
	}

}
