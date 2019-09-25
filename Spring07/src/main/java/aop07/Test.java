package aop07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		// ** Ioc/DI => Spring 컨테이너로부터 주입받기
		AbstractApplicationContext ck =
				new GenericXmlApplicationContext("aop07/appCon.xml");
		Person cookerb = (Person)ck.getBean("cookerb");
		Person cookerg = (Person)ck.getBean("cookerg");
		try {
			System.out.println("** Boy Test **");
			cookerb.doSomething();
			System.out.println("** Girl Test **");
			cookerg.doSomething();
		} catch (Exception e) {
			System.out.println("main Exception => "+e.toString());
		}
		ck.close();
	} // main
} // class
