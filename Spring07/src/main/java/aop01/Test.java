package aop01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ** ���� JAVA : ������
		//Person cooker = new Boy();
		//Person cooker = new Girl();
		//cooker.doSomething();
		
		// ** Ioc/DI => Spring �����̳ʷκ��� ���Թޱ�
		AbstractApplicationContext ck = new GenericXmlApplicationContext("aop01/appCon.xml");
		Person cooker = (Person)ck.getBean("cooker");
		cooker.doSomething();
		ck.close();
	}

}
