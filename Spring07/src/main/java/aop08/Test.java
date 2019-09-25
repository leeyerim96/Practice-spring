package aop08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		// ** Ioc/DI => Spring 컨테이너로부터 주입받기
		AbstractApplicationContext ck =
				new GenericXmlApplicationContext("aop08/appCon.xml");
		Person cookerb = (Person)ck.getBean("cookerb");
		Person cookerg = (Person)ck.getBean("cookerg");
		try {
			System.out.println("** Boy Test **");
			System.out.println("main result=>"+cookerb.doSomething("10"));
			System.out.println("** Girl Test **");
			System.out.println("main result=>"+cookerg.doSomething("20"));
		} catch (Exception e) {
			System.out.println("main Exception => "+e.toString());
		}
		ck.close();
	} // main
} // class
